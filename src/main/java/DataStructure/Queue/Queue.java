package DataStructure.Queue;

public interface Queue<E> {

    /**
     * 向队列尾部插入value
     * @param value
     * @return true - 插入成功, false - 插入失败
     */
    boolean offer(E value);

    /**
     * 从队列头获取值，并移除
     * @return 如果队列非空，返回队列头的值， 否则返回null
     */
    E poll();

    /**
     * 从队列头获取值，不移除
     * @return 如果队列非空，返回队列头的值，否则返回null
     */
    E peek();

    /**
     * 检查队列是否为空
     * @return true - 队列为空, false - 队列非空
     */
    boolean isEmpty();

    /**
     * 检查队列的容量是否已经满了
     * @return true - 已经满了, false - 还没满
     */
    boolean isFull();

}
