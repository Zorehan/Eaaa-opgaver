import java.util.Arrays;

public class Opgaver {

    public static void main(String[] args)
    {
        int[] prefixArray = {5,10,5,6,4,9,8};
        prefixAverage(prefixArray);
        /*
        int[] funnyarray = {1,5,9,10};
        methodA(funnyarray, 4);
         */

    }

    //Opgave 1 del 1, er svaret O=n^2
    //Opgave 1 del 2, er svaret 0=n^3

    //Opgave 2 del 1, er O=(1)
    //Opgave 2 del 2, er 0=(n)
    //Opgave 2 del 3, er 0=(n^2)
    //Opgave 2 del 4, er 0=(n)
    //Opgave 2 del 5

    public static double[] prefixAverage(int[] inputTal) {
        double[] result = new double[inputTal.length];
        double sum = 0;

        for (int i = 0; i < inputTal.length; i++) {
            sum += inputTal[i];
            result[i] = sum / (i + 1);
            System.out.println(Arrays.toString(result));
        }
        return result;

    }

    public static void methodA(int[] array, int n)
    {
        for (int index = 0; index < n -1; index++)
        {
            int mark = privatemethodA(array, index, n-1);
            int temp = array[index];
            array[index] = array[mark];
            array[mark] = temp;
            System.out.println("n is" + n);
            System.out.println("mark is" + mark);
            System.out.println("temp is" + temp);
        }
    }

    private static int privatemethodA(int[] array, int first, int last)
    {
        int min = array[first];
        int indexOfMin = first;
        for(int index = first + 1; index <= last; index++)
        {
            if(array[index] < min)
            {
                min = array[index];
                indexOfMin = index;
            }
        }
        return indexOfMin;
    }


}
