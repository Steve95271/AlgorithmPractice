package DataStructure.StackAndQueue.PriorityQueue;

public interface Queue<E> {
    public boolean addElement(E element);

    /**
     * 返回第一个元素并删除
     * @return 第一个元素
     */
    public E poll();

    /**
     *
     * @return
     */
    public E peek();

    public boolean isEmpty();

    public boolean isFull();
}
