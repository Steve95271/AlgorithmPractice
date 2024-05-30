package DataStructure.Queue.BlockingQueue;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 双锁实现的阻塞队列
 * @param <E> 范型
 */
public class BlockingQueueImpl2<E> implements BlockingQueue<E>{

    private final E[] array;
    private int head;
    private int tail;
    // 原子整数类，用于确保size的加减的原子性
    private AtomicInteger size = new AtomicInteger();

    private ReentrantLock tailLock = new ReentrantLock(); // 保护tail指针
    private Condition tailWaits = tailLock.newCondition();

    private ReentrantLock headLock = new ReentrantLock(); // 保护head指针
    private Condition headWaits = headLock.newCondition();

    public BlockingQueueImpl2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private boolean isEmpty() {
        return size.get() == 0;
    }

    private boolean isFull() {
        return size.get() == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        int queueSizeBeforeAdd;

        tailLock.lockInterruptibly();
        try {
            // 1.队列满则等待
            while (isFull()) {
                tailWaits.await();
            }

            // 2.不满则入队
            array[tail] = e;
            //tail先加一然后在做判断，如果索引已经到达数组的最后一位需要把tail索引重制为0
            //这样做是为了防止索引超出范围
            if (++tail == array.length) {
                tail = 0;
            }

            // 3.修改size
            queueSizeBeforeAdd = size.getAndIncrement();
            // 如果队列元素在增加前加上一还是不满的话，说明队列还有空位
            if (queueSizeBeforeAdd + 1 < array.length) {
                tailWaits.signal();
            }

        } finally {
            tailLock.unlock();
        }

        // 4. 唤醒等待中的poll线程
        // 队列中的元素从 0 -> 1(不空) 的情况下由offer线程唤醒等待中的poll线程
        if (queueSizeBeforeAdd == 0) {
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        return false;
    }

    @Override
    public E poll() throws InterruptedException {
        E e;
        int queueSizeBeforeDec;

        headLock.lockInterruptibly();
        try {
            // 1.队列空则等待
            while (isEmpty()) {
                headWaits.await();
            }

            // 2.队列不空，取出元素
            e = array[head];
            array[head] = null; // Help GC
            //防止指针越界
            if (++head == array.length) {
                head = 0;
            }

            // 3.修改Size
            queueSizeBeforeDec = size.getAndDecrement();
            // 因为在offer线程的headWaits.signal()方法只会唤醒一个等待中的poll线程
            // 所以如果队列中的元素在减少前是大于一（也就是说还有两个以上元素），此时应该唤醒其它等待中的poll线程
            if (queueSizeBeforeDec > 1) {
                headWaits.signal(); //poll自己唤醒其它等待中的poll线程
            }
        } finally {
            headLock.unlock();
        }

        // 4. 唤醒等待不满的offer线程
        // 队列从满 -> 不满的时候 才由poll唤醒等待不满的offer线程
        if (queueSizeBeforeDec == array.length) { //变量记录的是队列在减少前是满
            tailLock.lock();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }

        return e;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueueImpl2<String> queue = new BlockingQueueImpl2<>(3);

        queue.offer("元素一");
        queue.offer("元素二");


        new Thread(() -> {
            try {
                queue.offer("元素三");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "offer_1").start();

        new Thread(() -> {
            try {
                String element = queue.poll();
                System.out.println("poll_1: " + element);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "poll_1").start();
    }
}
