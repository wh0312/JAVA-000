package jvm;

public class VolatileMethod {
    public static int result;
    public volatile boolean isFinish = false;

    public int method1()
    {
        new Thread()
        {
            @Override
            public void run() {
                result = Calc.sum();
                isFinish = true;
            }
        }.start();

        while (!isFinish)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
