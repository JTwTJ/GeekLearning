package Temp;

/**
 * @author jiangwentao
 * @date 2021/8/24
 * @detail 两个线程交替打印
 */
public class TwoThreadPrint {

    private boolean flag = true;
    private Object lock = new Object();
    private static volatile int i = 0;

    private void print() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (i < 100) {
                    synchronized (lock) {
                        if (flag) {
                            System.out.println("a" + "-----" + i++);
                            flag = !flag;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 100) {
                    synchronized (lock) {
                        if (!flag) {
                            System.out.println("b" + "-----" + i++);
                            flag = !flag;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        TwoThreadPrint test = new TwoThreadPrint();
        test.print();
    }
}
