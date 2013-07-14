package stealData;

import java.io.IOException;

public class Command implements Runnable
{

    private String localUrl;

    private String targetUrl;

    private boolean needProxy = false;

    public Command(String localUtl, String targetUrl, boolean needProxy)
    {
        this.localUrl = localUtl;

        this.targetUrl = targetUrl;

        this.needProxy = needProxy;

    }

    @Override
    public void run()
    {
        try
        {
            DownloadService.outPutData(targetUrl, localUrl, needProxy);
        }
        catch(IOException e)
        {

            e.printStackTrace();
        }

    }

}
