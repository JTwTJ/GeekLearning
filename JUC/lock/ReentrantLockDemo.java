package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
//    private static Condition b = lock.newCondition();
    private static int flag = 1;

    String value;

    public ReentrantLockDemo(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
//        final Count count = new Count();
//
//        for (int i = 0; i < 2; i++) {
//            new Thread(() -> count.get()).start();
//        }
//
//        for (int i = 0; i < 2; i++) {
//            new Thread() {
//                public void run() {
//                    count.put();
//                }
//            }.start();
//        }
        //a
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    lock.lock();
//                    if (flag == 1) {
                        a.await();
//                    }
                    ReentrantLockDemo demo1 = new ReentrantLockDemo("a");
                    demo1.print();
//                    flag = 2;
//                    b.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

//                LockSupport.park();
//                ReentrantLockDemo demo1 = new ReentrantLockDemo("a");
//                demo1.print();
            }
        });
        //b
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    lock.lock();
//                    if (flag == 2) {
//                        b.await();
//                    }
                    ReentrantLockDemo demo2 = new ReentrantLockDemo("b");
                    demo2.print();
                    a.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
//                ReentrantLockDemo demo2 = new ReentrantLockDemo("b");
//                demo2.print();
//                LockSupport.unpark(thread1);
            }
        });
        thread1.start();
        thread2.start();
    }

    public void print() {
        System.out.println(this.value);
    }
}
