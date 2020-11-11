package jvm;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchMethod {
    public int result;
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    public int method1()
    {
        new Thread()
        {
            @Override
            public void run() {
                result = Calc.sum();
                countDownLatch.countDown();
            }
        }.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}
