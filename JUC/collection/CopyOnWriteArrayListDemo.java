package collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    
    public static void main(String[] args) {
    
        // ArrayList，LinkedList，Vector不安全，运行报错
        // why Vector 也不安全
//        List<Integer> list = new ArrayList<Integer>();
//        List<Integer> list = new LinkedList<>();
//        List<Integer> list = new Vector<>();
    
        // 只有CopyOnWriteArrayList 安全，不报错 因为此时的writeList是原list的一个snapshot快照，
        // readLists是原list，两者的读写分别是两个不同的list，所以读写加起来依然是原子性的
        List<Integer> list = new CopyOnWriteArrayList();
        
        for (int i = 0; i < 10000; i++)
        {
            list.add(i);
        }
    
        T1 t1 = new T1(list);
        T2 t2 = new T2(list);
        t1.start();
        t2.start();
        
    }
    
    public static class T1 extends Thread
    {
        private List<Integer> list;
        
        public T1(List<Integer> list)
        {
            this.list = list;
        }
        
        public void run()
        {
            for (Integer i : list)
            {
                System.out.println("read====>" + i);
            }
        }
    }
    
    public static class T2 extends Thread
    {
        private List<Integer> list;
        
        public T2(List<Integer> list)
        {
            this.list = list;
        }
        
        public void run()
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < list.size(); i++)
            {
                Integer remove = list.remove(i);
                System.out.println("remove====>" + remove);
            }
        }
    }
    
}
