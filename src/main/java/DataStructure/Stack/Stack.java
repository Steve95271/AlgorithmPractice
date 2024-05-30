package DataStructure.Stack;

public interface Stack<E> {
    /**
     * push element to the top of the stack
     * @param value
     * @return true - if element success pushed into the stack. false - if the stack is full
     */
    boolean push(E value);

    /**
     * pop an element from top of the stack.
     * @return the top element. null - if stack is empty.
     */
    E pop();

    /**
     * Peeeeeeeeek the top element. Not pop ok? This will not remove the top element.
     * @return the top element. null - if the stack is empty. you can't see the not exist thing hahaha.
     */
    E peek();

    /**
     *
     * @return true - if the stack empty. false - if the stack still have elements.
     */
    boolean isEmpty();

    /**
     *
     * @return true - if is full. false - not full.
     */
    boolean isFull();
}
