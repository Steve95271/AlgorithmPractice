import DataStructure.Queue.BlockingQueue.BlockingQueueImpl1;
import DataStructure.Queue.BlockingQueue.BlockingQueueImpl2;
import org.junit.jupiter.api.Test;


public class TestBlockingQueue {

    @Test
    void test1() throws InterruptedException {
        BlockingQueueImpl1<String> blockingQueue = new BlockingQueueImpl1<>(3);

        Thread t1 = new Thread(() ->{
            try {
                blockingQueue.offer("任务一");
                System.out.println(blockingQueue);
                blockingQueue.offer("任务二");
                System.out.println(blockingQueue);
                blockingQueue.offer("任务三");
                System.out.println(blockingQueue);
                blockingQueue.offer("任务四", 5000);
                System.out.println(blockingQueue);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "生产者");

        t1.start();

        Thread.sleep(2000);

        blockingQueue.poll();
    }

    @Test
    void test2() throws InterruptedException {
        BlockingQueueImpl2<String> queue = new BlockingQueueImpl2<>(3);

        new Thread(() -> {
            try {
                String element = queue.poll();
                System.out.println(element);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "poll_1").start();

        new Thread(() -> {
            try {
                String element = queue.poll();
                System.out.println(element);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "poll_2").start();

        new Thread(() -> {
            try {
                 queue.offer("元素");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "offer_1").start();
    }

}
