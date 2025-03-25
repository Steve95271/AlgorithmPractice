package DataStructure.Queue.BlockingQueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单锁实现的阻塞队列
 * @param <E>
 */
public class BlockingQueueImpl1<E> implements BlockingQueue<E>{

    private final E[] array;
    private int head;
    private int tail;
    private int size;

    public BlockingQueueImpl1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition headWaits = lock.newCondition();
    private Condition tailWaits = lock.newCondition();

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public void offer(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isFull()) {
                //如果数组为满，则让此线程进入等待
                tailWaits.await();
            }

            array[tail] = e;

            //tail先加一然后再做判断，如果索引已经到达数组的最后一位需要把tail索引重制为0
            //这样做是为了防止索引超出范围
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 在添加元素陷入等待时可以设置等待时间。如果超过时间则取消等待
     * @param e 添加的元素
     * @param timeout 等待时间
     * @return true - 添加成功, false - 超过等待时间，添加失败
     */
    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            //毫秒转换成纳秒
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                if (nanos <= 0) { //超过等待时间，返回失败
                    return false;
                }
                //更新剩余的等待时间，避免虚假唤醒
                nanos = tailWaits.awaitNanos(nanos);
            }
            array[tail] = e;
            //tail先加一然后在做判断，如果索引已经到达数组的最后一位需要把tail索引重制为0
            //这样做是为了防止索引超出范围
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }
            E e = array[head];
            array[head] = null; //help GC
            //head先加一然后在做判断，如果索引已经到达数组的最后一位需要把head索引重制为0
            //这样做是为了防止索引超出范围
            if (++head == array.length) {
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }
}
