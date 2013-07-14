package dailyDev;

import java.util.HashMap;
import java.util.Map;

public class Test
{
    private static int[] array = new int[] { 1, 2, 3 };

    private static int spaceNum = 0;

    private static int numberNum = 0;

    private static int characterNum = 0;

    private static int otherNum = 0;

    @SuppressWarnings("static-access")
    public static void main(String[] args)
    {
        // String s = "�Ҳ�nidate1��������FUCKYOUbitch";
        // otherHandleString(s);
        // System.out.println(spaceNum);
        // System.out.println(numberNum);
        // System.out.println(characterNum);
        // System.out.println(otherNum);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key:userName", "userName");
//        mapOutput(map);
        
        System.out.println(map);
    }

    /**
     * ͨ��CHARACTER ��������һ���ж�
     * 
     * @param s
     * @see [�ࡢ��#��������#��Ա]
     */
    public static void otherHandleString(String s)
    {
        char[] charArray = s.toCharArray();
        for (char c : charArray)
        {
            if (Character.isUpperCase(c) || Character.isLowerCase(c))
            {
                characterNum++;
                continue;
            }

            if (Character.isSpaceChar(c))
            {
                spaceNum++;
                continue;
            }
            if (Character.isDigit(c))
            {
                numberNum++;
                continue;
            }

            otherNum++;
        }

    }

    public static void handleString(String s)
    {

        char[] charArray = s.toCharArray();

        for (char c : charArray)
        {

            if (c == ' ')
            {
                spaceNum++;
                continue;
            }

            if (c >= '1' && c <= '9')
            {
                numberNum++;
                continue;
            }

            if ('A' <= c && c <= 'z')
            {
                characterNum++;
                continue;
            }

            otherNum++;
        }
    }

    public static void mapOutput(Map<String, Object> map)
    {

        for (String key : map.keySet())
        {
            System.out.println(key + "key======");
            System.out.println(map.get(key) + "value======");
        }
    }

}
