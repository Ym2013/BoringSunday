package dailyDev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex
{

    public static void main(String[] args)
    {
        outputWord("hello! world");
        
        testRemoveSpace("hello!! \n world    ");
    }

    public static void outputWord(String s)
    {
        // s = s.replaceAll("\\W", "");
        // System.out.println(s);
        Pattern pattern = Pattern.compile("((\\w*)\\W{0,})");

        Matcher matcher = pattern.matcher(s);

        while (matcher.find())
        {
            System.out.println(matcher.group(1));
        }
    }

    public static void testRemoveSpace(String s)
    {
       System.out.println("space replace"+s.replaceAll(" ", ""));
       
       System.out.println("regex "+s.replaceAll("\\s", ""));
       
       System.out.println("remove singal"+s.replaceAll("\\pP", "$0"));
    }
}
