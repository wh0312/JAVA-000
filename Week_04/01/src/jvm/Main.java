package jvm;

public class Main {



    public static void main(String[] args) {
	// write your code here
        long start=System.currentTimeMillis();
        System.out.println("JoinMethod 异步计算结果为："+new JoinMethod().method1());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        start=System.currentTimeMillis();
        System.out.println("WaitMethod 异步计算结果为："+new WaitMethod().method1());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        start=System.currentTimeMillis();
        System.out.println("CallableMethod 异步计算结果为："+new CallableMethod().method1());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        start=System.currentTimeMillis();
        System.out.println("VolatileMethod 异步计算结果为："+new VolatileMethod().method1());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        start=System.currentTimeMillis();
        System.out.println("ConditionMethod 异步计算结果为："+new ConditionMethod().method1());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        start=System.currentTimeMillis();
        System.out.println("SemaphoreMethod 异步计算结果为："+new SemaphoreMethod().method1());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        start=System.currentTimeMillis();
        System.out.println("CountDownLatchMethod 异步计算结果为："+new CountDownLatchMethod().method1());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
