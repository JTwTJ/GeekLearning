
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */
public class Homework03 implements Callable<Integer> {

    private static int value = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        //method1
//        // 在这里创建一个线程或线程池，
//        // 异步执行 下面方法
//        Homework03 homework03 = new Homework03();
//        FutureTask<Integer> futureTask = new FutureTask<>(homework03);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(futureTask);
//        System.out.println(futureTask.get());
//        executorService.shutdown();

        //method2
//        Integer integer = CompletableFuture.supplyAsync(Homework03::sum).get();
//        System.out.println(integer);
//        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        //method3
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                value = sum();
//                countDownLatch.countDown();
//            }
//        }).start();
//        countDownLatch.await();
//        System.out.println(value);
//        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        //method4
        Lock lock = new ReentrantLock();
        lock.lock();
        value = sum();
        lock.unlock();
        System.out.println(value);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    @Override
    public Integer call() throws Exception {
        return sum();
    }
}
