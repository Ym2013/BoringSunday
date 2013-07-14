package dailyDev;

/**
 * 
 * <一句话功能简述> 欧几里得算法 ： 辗转相除法
 * 
 * @author Administrator
 * @version [版本号, 2013-6-22]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class JustPlay
{

    public static int[] array = new int[] { 1, 2, 3, 4, 5, 6 };

    public static void main(String[] args)
    {
        // System.out.println(gcd(10, 53));

        System.out.println(getNumIndex(array, 0, array.length - 1, 8));
    }

    public static int gcd(int a, int b)
    {

        int max = Math.max(a, b);

        int min = Math.min(a, b);

        int mod = max % min;

        // if (mod != 0)
        // {
        // return gcd(min, mod);
        // }

        while (mod != 0)
        {
            return gcd(mod, max);
        }
        return min;
    }

    public static int getNumIndex(int[] array, int left, int right, int num)
    {

        if (left == right)
        {
            return array[right] == num ? right : -1;
        }
        else
        {

            int middle = (left + right) / 2;

            if (array[middle] == num)
            {
                return middle;
            }

            if (array[middle] > num)
            {
                return getNumIndex(array, left, middle - 1, num);
            }

            return getNumIndex(array, middle + 1, right, num);
        }

    }
}
