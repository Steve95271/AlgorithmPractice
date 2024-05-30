package DataStructure.StackAndQueue;

public class test {
    public static void main(String[] args) {
        Stack<Integer> s = new ArrayStack<>();

        s.push(5);
        s.push(3);
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        s.push(7);
        s.push(9);
        System.out.println(s.top());
        s.push(4);
        System.out.println(s.size());

    }
}
