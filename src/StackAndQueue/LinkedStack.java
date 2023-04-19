package StackAndQueue;



public class LinkedStack<E> implements Stack<E>{
    private SinglyLinkedList<E> list = new SinglyLinkedList();

    public LinkedStack(){};

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.addFirst(element);
    }

    public E top() {
        return list.first();
    }

    public E pop() {
        return list.removeFirst();
    }

    public static <E> void reverse(E[] a){
        Stack<E> buffer = new ArrayStack<>(a.length);

        for(int i = 0; i < a.length; i++){
            buffer.push(a[i]);
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = buffer.pop();
        }
    }

    public static boolean isMatched(String expression) {
        final String opening = "({[<.";
        final String closing = ")}]>."; //({[123456)}]

        Stack<Character> buffer = new LinkedStack<>();

        for (char c : expression.toCharArray()){
            if (opening.indexOf(c) != -1){
                buffer.push(c);
            } else if (closing.indexOf(c) != -1) {
                if (buffer.isEmpty()){
                    return false;
                }

                if(closing.indexOf(c) != opening.indexOf(buffer.pop())){
                    return false;
                }
            }
        }

        return buffer.isEmpty();
    }
}
