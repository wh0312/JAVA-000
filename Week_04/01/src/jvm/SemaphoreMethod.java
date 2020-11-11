package jvm;

import java.util.concurrent.Semaphore;

public class SemaphoreMethod {
    public int result;
    public Semaphore obj = new Semaphore(1);
    public int method1()
    {
        new Thread()
        {
            @Override
            public void run() {
                try {
                    obj.acquire();
                    result = Calc.sum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    obj.release();
                }
            }
        }.start();
        try {
            Thread.sleep(5);
            obj.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            obj.release();
        }
        return result;
    }
}
