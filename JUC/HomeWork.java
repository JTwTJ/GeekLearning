package JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author jiangwentao
 * @date 2021/2/25
 */
public class HomeWork {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("a");
//            }
//        });
//
//        thread.start();

        //method 1
        for (int i = 0; i < 1000; i++) {
            MyThread myThread = new MyThread(i);
            FutureTask<Integer> futureTask = new FutureTask<>(myThread);
            new Thread(futureTask).start();
            Integer count = futureTask.get();
            System.out.println(count);
        }

    }
    static class MyThread implements Callable<Integer> {

        private int count;

        public MyThread(int count) {
            this.count = count;
        }

        @Override
        public Integer call() throws Exception {
            return count;
        }
    }
}
