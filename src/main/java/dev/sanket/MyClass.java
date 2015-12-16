package dev.sanket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MyClass
{
    public void myMethod()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(2, new MyThreadFactory());

        for (int count = 0; count < 2; count++)
        {
            executorService.submit(new Thread());
        }
    }
}

class MyThreadFactory implements ThreadFactory
{
    @Override
    public Thread newThread(Runnable r)
    {
        return null;
    }
}
