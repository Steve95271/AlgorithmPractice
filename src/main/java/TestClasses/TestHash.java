package TestClasses;

public class TestHash {

    public static void main(String[] args) {
        //StringBuilder hello1 = new StringBuilder("Hello");
        //StringBuilder hello2 = new StringBuilder("Hello");
        String a = new String("Hello");
        String b = "Hello";

        System.out.println("A hash: " + a.hashCode());
        System.out.println("B hash: " + b.hashCode());
        System.out.println("Compare: " + (a == b));
    }

}
