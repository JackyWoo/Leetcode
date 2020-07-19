package concurrency;

import java.util.concurrent.Semaphore;

/**
 * Semaphore语义：控同时运行的线程个数
 *
 * Created by wujianchao on 2020/7/17.
 */
public class SemaphoreDemo {

    static class Task extends Thread {
        Semaphore semaphore;
        public Task(Semaphore semaphore){
            this.semaphore = semaphore;
        }
        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + " 获得执行资格");
                semaphore.release();
                System.out.println(getName() + " 执行完成");
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for(int i=0;i<5;i++){
            new Task(semaphore).start();
        }
    }
}
