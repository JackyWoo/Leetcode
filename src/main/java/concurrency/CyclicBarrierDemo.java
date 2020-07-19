package concurrency;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier语义：所有线程中等待到一个时间点，然后一起执行后续的工作
 *
 * Created by wujianchao on 2020/7/17.
 */
public class CyclicBarrierDemo {

    static class Task extends Thread {
        int n;
        CyclicBarrier barrier;
        public Task(CyclicBarrier barrier, int n){
            this.barrier = barrier;
            this.n = n;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(n*1000);
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + " sleep " + n + "s");
            try {
                barrier.await();
            } catch (Exception e) {
            }
            System.out.println(getName() + " go on next work!");
        }
    }

    public static void main(String[] args) {
        int n = 10;
        CyclicBarrier barrier = new CyclicBarrier(n);
        for(int i=0;i<n;i++){
            new Task(barrier, i).start();
        }

    }
}
