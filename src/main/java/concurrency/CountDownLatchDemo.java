package concurrency;

import java.util.concurrent.CountDownLatch;

/**
 *
 * CountDownLatch语义：等待线程全部就绪，全部就绪后再往下执行
 *
 * Created by wujianchao on 2020/7/17.
 */
public class CountDownLatchDemo {

    static class TaskThread extends Thread {
        CountDownLatch latch;
        public TaskThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            } finally {
                System.out.println(getName() + " Task is Done");
                latch.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for(int i=0;i<10;i++){
            TaskThread t = new TaskThread(latch);
            t.start();
        }
        latch.await();
        System.out.println("all done!");
    }
}
