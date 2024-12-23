package movieexercise;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoviesApp {
    public static List<Movie> readMovies(String filename) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNextLine()) {
                String nameLine = in.nextLine();
                String yearLine = in.nextLine();
                String directorsLine = in.nextLine();
                String producersLine = in.nextLine();
                String actorsLine = in.nextLine();
                movies.add(new Movie(getString(nameLine),
                        Integer.parseInt(getString(yearLine)),
                        getList(directorsLine), getList(producersLine),
                        getList(actorsLine)));
            }
        }
        return movies;
    }

    private static String getString(String line) {
        int colon = line.indexOf(":");
        return line.substring(colon + 1).trim();
    }

    private static List<String> getList(String line) {
        return Stream.of(getString(line).split(", "))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        List<Movie> movieList = readMovies("movies.txt");
//        for (Movie m : movieList) {
//            System.out.println(m.getTitle());
//        }

        //  The number of movies starting with "H"

        long countStartingWithH = movieList.stream()
                .filter(movie -> movie.getTitle().startsWith("H"))
                .count();
        System.out.println("antallet af film der starter med H: " + countStartingWithH);

        //Film der starter med X

        List<Movie> movieStartingWithX = movieList.stream().filter(movie -> movie.getTitle().startsWith("X")).toList();
        for(Movie movie: movieStartingWithX)
        {
            System.out.println("film der starter med X : " + movie.getTitle());
        }

        // The number of films where the director is also an actor

        Long directorAlsoActorCount = movieList.stream()
                .filter(movie -> movie.getDirectors().stream()
                        .anyMatch(director -> movie.getActors().contains(director)))
                .count();
        System.out.println("film hvor produceren også er en skuespiller: " + directorAlsoActorCount);

        //The number of actors in the film with the most actors

        int maxActorsCount = movieList.stream()
                .mapToInt(movie -> movie.getActors().size())
                .max()
                .orElse(0);

        System.out.println("antallet af skuespillere i filmen med flest skuespillere: " + maxActorsCount);

        // The title of the film with the most actors
        movieList.stream()
                .max(Comparator.comparingInt(movie -> movie.getActors().size()))
                .ifPresent(movie -> System.out.println("film med flest skuespillere: " + movie.getTitle()));


        //Number of films divided by first letter in the film title
        Map<Character, Long> filmsByFirstLetterWithSpace = movieList.stream()
                .filter(movie -> movie.getTitle().length() > 1 && movie.getTitle().charAt(1) == ' ')
                .collect(Collectors.groupingBy(movie -> movie.getTitle().charAt(0), Collectors.counting()));

        System.out.println("Number of films divided by first letter (followed by a space):");
        filmsByFirstLetterWithSpace.forEach((letter, count) -> System.out.println(letter + ": " + count));



    }


}

