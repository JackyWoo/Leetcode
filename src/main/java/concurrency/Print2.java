package concurrency;

/**
 *
 * 三个线程交替打印
 *
 * 思路：每个线程持有两个锁，一个是前一个锁，一个自己的锁，这样讲三个线程串联成一个环形。
 *
 * 每个线程在的加锁流程：
 *      1. 获取前一个锁
 *      2. 获取自己的锁
 *      3. 打印
 *      4. 通知下一个线程（self.notify）
 *      5. 等待前一个锁释放（pre.wait）
 *
 * Created by wujianchao on 2020/7/17.
 */
public class Print2 {


    static class Printer implements Runnable {

        String content;
        Object pre;
        Object self;

        public Printer(String content, Object pre, Object self){
            this.content = content;
            this.pre = pre;
            this.self = self;
        }

        @Override
        public void run() {
            for(int i=0;i<100;i++) {
                //先获取前一个锁
                synchronized (pre){
                    //在获取自己的锁
                    synchronized (self){
                        System.out.println(content);
                        // 打印完成后释放自己的锁
                        self.notify();
                    }
                    try {
                        // 等待前一个锁
                        pre.wait();
                    } catch (InterruptedException e) {
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();

        Thread s1 = new Thread(new Printer("A", lock3, lock1));
        Thread s2 = new Thread(new Printer("B", lock1, lock2));
        Thread s3 = new Thread(new Printer("C", lock2, lock3));

        s1.start();
        Thread.sleep(10);
        s2.start();
        Thread.sleep(10);
        s3.start();
    }
}
