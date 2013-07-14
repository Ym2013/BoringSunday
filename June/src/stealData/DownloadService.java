package stealData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.Proxy.Type;

public class DownloadService
{

    public static void main(String[] args) throws Exception
    {
        // http://nj.tuniu.com/tours/303352

        // http://meishi.suning.com/lifesquare/homePage/queryHomePage_1002166.htm

        // while(true){

     

      
        outPutData("http://www.youku.com", "d://youku.txt", false);

         
        // }
    }

    // 本地测试不需要代理
    public static void outPutData(String targetUrl, String localUrl,
            boolean needproxy) throws IOException
    {
        URL url = new URL(targetUrl);

        URLConnection conn;

        if (needproxy)
        {

            SocketAddress address = new InetSocketAddress("192.168.1.1", 8080);
            Proxy proxy = new Proxy(Type.HTTP, address);
            conn = url.openConnection(proxy);
        }
        else
        {
            conn = url.openConnection();
        }

        conn.setConnectTimeout(3000);

        InputStream ins = conn.getInputStream();
        OutputStream os = new FileOutputStream(new File(localUrl));

        // byte[] byteArray = new byte[ins.available()];

        byte[] tempArray = new byte[1024];

        while (ins.read(tempArray) != -1)
        {
            os.write(tempArray);
        }

        // ins.read(byteArray);

        // System.out.println(byteArray.length + "=============");
        ins.close();

        // os.write(byteArray);

        os.close();
    }
}
