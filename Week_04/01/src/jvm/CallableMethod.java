package jvm;

import java.util.concurrent.*;

public class CallableMethod {

    public int method1()
    {
        ExecutorService excutor = Executors.newSingleThreadExecutor();
        Future<Integer> result =  excutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return Calc.sum();
            }
        });

        try {
            return result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            excutor.shutdown();
        }
        return -1;
    }
}
