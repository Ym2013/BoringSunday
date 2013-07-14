package stealData;

import java.util.ArrayList;
import java.util.List;

public class DownloadSuningData
{

    public static void main(String[] args)
    {

        stealData(1002166, 1002176);
    }

    public static void stealData(int start, int end)
    {
        ThreadPoolManager threadPoolManager = ThreadPoolManager.getInstance();

        List<String> localUrlList = AssembleUrl.genUrlList(start, end, "d:",
                null, ".txt");
        // http://meishi.suning.com/lifesquare/homePage/queryHomePage_1002166.htm

        List<String> targetUrlList = AssembleUrl.genUrlList(start, end,
                "http://meishi.suning.com/lifesquare/homePage/queryHomePage",
                "_", ".htm");

        List<Command> commandList = new ArrayList<Command>();
        Command command;
        int size = localUrlList.size();
        
        System.out.println(size);
        for (int i = 0; i < size; i++)
        {
            String tempLocalUrl = localUrlList.get(i);

            String tempTargetUrl = targetUrlList.get(i);

            command = new Command(tempLocalUrl, tempTargetUrl, false);
            commandList.add(command);
        }

        for (Command temp : commandList)
        {

            threadPoolManager.execute(temp);
        }
        threadPoolManager.terminate();

    }
}
