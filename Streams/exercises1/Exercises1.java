package exercises1;

import java.util.*;
import java.util.stream.Collectors;

public class Exercises1 {

    public static void main(String[] args) {
        // Liste med tal mellem 1 - 50
        List<Integer> list = List.of(1,2,3,2,1,6,3,4,5,2,3,8,8,9,34,32);
        list.stream().forEach(e-> System.out.println(e+1));

        //	Udskriver det største element i listen
        System.out.println(list.stream().max(Integer::compareTo));

        //	Afgør og udskriver om alle tallene i listen er mindre end 50

        System.out.println(list.stream().allMatch(integer -> integer < 50));

        // 	Udskriver antallet af lige tal i listen
        List<Integer> evenNumbers = list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even numbers: " + evenNumbers);


        //	Udskriver antallet af ulige tal i listen

        List<Integer> unevenNumbers = list.stream().filter(integer -> integer % 2 != 0).collect(Collectors.toList());

        System.out.println("Uneven numbers:" + unevenNumbers);


        //  Udskriver
        //      Gennemsnittet af tallene i listen
        //      Antallet af tallene i listen
        //      Antallet af tallene i listen der er større end gennemsnittet
        //      Antallet af tallene i listen der er mindre end gennemsnittet

        IntSummaryStatistics stats = list.stream().mapToInt(Integer::intValue).summaryStatistics();

        long sumOfList = stats.getSum();
        double avgOfList = stats.getAverage();

        List<Integer> aboveAverage = list.stream()
                .filter(num -> num > avgOfList)
                .collect(Collectors.toList());

        List<Integer> belowAverage = list.stream()
                .filter(num -> num < avgOfList)
                .collect(Collectors.toList());

        System.out.println("The sum is: " + sumOfList + " Numbers above average: " +aboveAverage + " numbers below average: " + belowAverage);

        //	Udskriver antallet af gange de forskellige tal forekommer i listen

        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(e -> e.intValue(), Collectors.counting()));
        for(int i : map.keySet())
        {
            System.out.println("The number: " + i + " Appears " + map.get(i) + " times");
        }
        //	Udskriver antallet af gange de forskellige tal forekommer i listen i sorteret orden


        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        Map<Integer, Long> map2 = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));


        map2.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByKey(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println("The number: " + entry.getKey() + " Appears " + entry.getValue() + " times"));
    }
}
