package concurrency;

/**
 *
 * 两个线程交替打印
 *
 * Created by wujianchao on 2020/7/17.
 */
public class Print {

    static class Printer implements Runnable {
        Object lock;
        int inc;
        int base;

        public Printer(Object lock, int base, int inc){
            this.lock = lock;
            this.inc = inc;
            this.base = base;
        }

        @Override
        public void run() {
            for(int i=0;i<100;i+=inc) {
                // 获取锁
                synchronized (lock) {
                    // 打印
                    System.out.println(base + i);
                    // 通知下个线程自己打印好了
                    lock.notify();
                    try {
                        // 等待锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();

        Thread s1 = new Thread(new Printer(lock, 0, 3));
        Thread s2 = new Thread(new Printer(lock, 1, 3));

        s1.start();
        s2.start();
    }
}
