package dev.sanket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Executors.class, MyClass.class})
public class MyClassTest
{
    @Test
    public void testMyMethod()
    {
        prepareMocks();

        /*
         * Within myClass.myMethod(), Executors.newFixedThreadPool() returns actual instance of ThreadPoolExecutor
         * instead of mocked object
         */
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }

    private void prepareMocks()
    {
        ExecutorService executorService = PowerMock.createMock(ExecutorService.class);
        EasyMock.expect(executorService.submit(EasyMock.anyObject(Runnable.class))).andReturn(null).anyTimes();

        PowerMock.mockStatic(Executors.class);
        EasyMock.expect(Executors.newFixedThreadPool(EasyMock.anyInt(), EasyMock.anyObject(ThreadFactory.class))).andReturn(executorService).anyTimes();

        PowerMock.replay(executorService, Executors.class, MyClass.class);
    }
}
