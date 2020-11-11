package jvm;

public class WaitMethod {
    public int result;
    public Object obj = new Object();
    public int method1()
    {
        new Thread()
        {
            @Override
            public void run() {
                synchronized (obj)
                {
                    result = Calc.sum();
                    obj.notify();
                }
            }
        }.start();
        synchronized (obj)
        {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
