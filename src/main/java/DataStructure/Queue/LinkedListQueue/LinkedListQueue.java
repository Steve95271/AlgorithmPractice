package DataStructure.Queue.LinkedListQueue;

import DataStructure.Queue.Queue;

import java.util.Iterator;

public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    /*
        单向环形列表的方式来实现队列
     */

    Node<E> head = new Node<>(null, null);
    Node<E> tail = head;
    private int size; //节点数
    private int capacity = Integer.MAX_VALUE;

    //把构造方法中重复的代码抽取到这里
    {
        tail.next = head;
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    public LinkedListQueue() {
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }

        Node<E> newNode = new Node<>(value, head);

        /*
            这一步tail.next = newNode不理解
            单向环形队列的tail节点的next指针不是应该指向head吗？

            答：
            应该是因为类中在实例化后把head的值赋给了tail，此时他们指向的引用数据是同一个。
            然后又因为构造方法在开始时把tail节点的next指针设为head，此时tail.next也是指向自己。
            因此tail和head指向的都是同一个对象，tail即系head，head即系tail。
         */
        tail.next = newNode; //这一步是相当于把哨兵节点的next设为新节点。
        tail = newNode; //然后再重新把新节点设为尾节点。
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        //先把队列的第一个节点获取到。（由于实现方式的原因，head的下一个节点才是头节点）
        Node<E> first = head.next;
        //设置新的头节点。也就是说原先的头节点要被移除掉了。
        head.next = first.next;
        //容量减一
        size--;
        //特殊情况，当队列中只剩下一个节点，需要把尾节点重新指向头节点
        if (first == tail) {
            tail = head;
        }
        //返回队列中原本的第一个节点的值。
        return first.value;
    }

    @Override
    public E peek() {
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        if (size >= capacity) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
