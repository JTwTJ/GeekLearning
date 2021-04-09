package atomic;

import java.util.concurrent.atomic.AtomicLong;

public class LongDemo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final AtomicLong atomicLong = new AtomicLong();
//        final LongAdder longAdder = new LongAdder();

        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        atomicLong.getAndIncrement();
//                        longAdder.increment();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("atomicLong=" + atomicLong.get());
//        System.out.println("longAdder =" + longAdder.sum());
        System.out.println("累计用时：" + (System.currentTimeMillis() - 1000L - start));
    }
}
