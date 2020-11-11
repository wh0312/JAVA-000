package jvm;

public class JoinMethod {

    public int result;

    public int method1()
    {
        Thread t = new Thread()
        {
            @Override
            public void run() {
                result = Calc.sum();
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}
