package TestClasses;

import DataStructure.Stack.LinkedListStack;

public class TestLinkedListStack {
    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>(5);

        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        linkedListStack.push(4);
        linkedListStack.push(5);

        for (Integer value : linkedListStack) {
            System.out.println(value);
        }


        System.out.print("Test peek: ");
        System.out.println(linkedListStack.peek());

        System.out.print("Test pop: ");
        System.out.println(linkedListStack.pop());

        System.out.println("=================");
        for (Integer value : linkedListStack) {
            System.out.println(value);
        }
    }
}
