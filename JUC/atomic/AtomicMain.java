
package atomic;

public class AtomicMain {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final SyncCount count = new SyncCount();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        count.add(); 
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("num=" + count.getNum());
        System.out.println("累计耗时：" + (System.currentTimeMillis() - 1000L - start));
    }

}
