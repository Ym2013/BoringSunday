package stealData;

import java.util.ArrayList;
import java.util.List;

public class AssembleUrl
{

    public static void main(String[] args)
    {
        List<String> localUrlList = AssembleUrl.genUrlList(10, 20, "d:", null,
                ".txt");
        // http://meishi.suning.com/lifesquare/homePage/queryHomePage_1002166.htm

        List<String> targetUrlList = AssembleUrl.genUrlList(10, 20,
                "http://meishi.suning.com/lifesquare/homePage/queryHomePage",
                "_", ".htm");

        for (String s : localUrlList)
        {
            System.out.println(s);
        }

        for (String s : targetUrlList)
        {
            System.out.println(s);
        }
    }

    public static String getTargetUrl(String prefix, String connector, int i,
            String suffix)
    {
        return prefix + connector + i + suffix;
    }

    public static String getLocalUrl(String prefix, int i, String suffix)
    {
        return prefix + i + suffix;
    }

    public static List<String> genUrlList(int start, int end, String prefix,
            String connector, String suffix)
    {

        List<String> resultList = new ArrayList<String>();

        if (null == connector)
        {

            for (int i = start; i < end; i++)
            {
                String tempUrl = getLocalUrl(prefix, i, suffix);
                resultList.add(tempUrl);
            }
        }
        else
        {
            for (int i = start; i < end; i++)
            {
                String tempUrl = getTargetUrl(prefix, connector, i, suffix);
                resultList.add(tempUrl);
            }
        }

        return resultList;
    }
}
