import java.util.stream.Stream;

public class Frabog {
    private static String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle", "john"};
    public static void main(String[] args)
    {

        largestString(names);
    }

    public static void largestString(String[] names)
    {
        System.out.println("\nLargest String with length > 4" + Stream.of(names).filter(e-> e.length() >4).max(String::compareTo).get());
    }

}
