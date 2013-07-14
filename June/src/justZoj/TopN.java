package justZoj;

public class TopN
{

    public static final int array[] = new int[] { 1, 3, 4, 5, 67, 8, 9 };

    public static void main(String[] args)
    {

//        int[] topNArray = getTopArray(3);
//        int sum = getSum(topNArray);
//
//        System.out.println(sum);
        
        System.out.println("2".matches("[1-5]"));
    }

    public static int[] getTopArray(int n)
    {
        int[] resultArray = new int[n];

        // INIT THE ARRAY
        resultArray = initArray(n);

        int arraySize = array.length;

        if (n < arraySize)
        {
            for (int i = n; i < arraySize; i++)
            {

                int tempIndex = getMinumIndex(resultArray);

                int min = resultArray[tempIndex];

                if (min < array[i])
                {
                    resultArray[tempIndex] = array[i];
                }

            }

        }
        return resultArray;

    }

    public static int getSum(int[] array)
    {
        int sum = 0;
        for (int s : array)
        {
            sum += s;
        }
        return sum;
    }

    public static int[] initArray(int n)
    {
        int[] resultArray = new int[n];

        for (int i = 0; i < n; i++)
        {
            resultArray[i] = array[i];
        }
        return resultArray;
    }

    public static int getMinumIndex(int[] array)
    {
        int result = 0;
        int temp = Integer.MAX_VALUE;
        int size = array.length;
        for (int i = 0; i < size; i++)
        {
            if (temp > array[i])
            {
                temp = array[i];

                result = i;
            }
        }
        return result;

    }

}
