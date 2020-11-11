package jvm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionMethod {
    public int result;
    public Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();


    public int method1()
    {
        new Thread()
        {
            @Override
            public void run() {
                lock.lock();
                try
                {
                    result = Calc.sum();
                    con.signal();
                }finally {
                    lock.unlock();
                }
            }
        }.start();


        try {
            lock.lock();
            con.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return result;
    }
}
