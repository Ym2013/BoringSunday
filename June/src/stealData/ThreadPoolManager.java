package stealData;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager
{

    private ThreadPoolManager()
    {

    }

    private static ThreadPoolManager instance = null;

    private ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(
            20);

    private ThreadPoolExecutor taskPool = new ThreadPoolExecutor(4, 4, 4,
            TimeUnit.SECONDS, queue, new ThreadPoolExecutor.CallerRunsPolicy());

    public static ThreadPoolManager getInstance()
    {
        if (null == instance)
        {
            instance = new ThreadPoolManager();
        }
        return instance;
    }

    public void execute(Runnable command)
    {
        taskPool.execute(command);
    }

    public void terminate()
    {

        while (true)
        {
            if (taskPool.getActiveCount() == 0)
            {

                taskPool.shutdown();
                break;
            }
        }
    }
}
