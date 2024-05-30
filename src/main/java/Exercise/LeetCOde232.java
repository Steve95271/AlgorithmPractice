package Exercise;

public class LeetCOde232 {
    class ArrayStack<E> {

        private E[] array;
        private int top; // 栈顶指针

        @SuppressWarnings("all")
        public ArrayStack(int capacity) {
            this.array = (E[]) new Object[capacity];
        }

        public boolean push(E value) {
            if (isFull()) {
                return false;
            }
            array[top++] = value;
            return true;
        }

        public E pop() {
            if (isEmpty()) {
                return null;
            }
            return array[--top];
        }

        public E peek() {
            if (isEmpty()) {
                return null;
            }
            return array[top - 1];
        }

        public boolean isEmpty() {
            return top == 0;
        }

        public boolean isFull() {
            return top == array.length;
        }
    }

    ArrayStack<Integer> stackA = new ArrayStack<>(100);
    ArrayStack<Integer> stackB = new ArrayStack<>(100);

    public void push(int x) {
        stackA.push(x);
    }

    public int pop() {
        if (!stackA.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }

        return stackB.pop();
    }

    public int peek() {
        if (!stackA.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }

        return stackB.peek();
    }

    public boolean empty() {
        return stackB.isEmpty();
    }
}
