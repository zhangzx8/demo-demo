package com.gome.test.spring;

public class Demo01 {

    static Object u = new Object();
    static TestSuspendThread t1 = new TestSuspendThread("t1");
    static TestSuspendThread t2 = new TestSuspendThread("t2");
 
    public static class TestSuspendThread extends Thread
    {
        public TestSuspendThread(String name)
        {
            setName(name);
        }
 
        @Override
        public void run()
        {
            synchronized (u)
            {
                System.out.println("in " + getName());
                Thread.currentThread().suspend();
            }
        }
    }
 
    public static void main(String[] args) throws InterruptedException
    {
        t1.start();
        t2.start();
        t1.resume();
        Thread.sleep(1000);
        t2.resume();
        t1.join();
        t2.join();
    }
}
