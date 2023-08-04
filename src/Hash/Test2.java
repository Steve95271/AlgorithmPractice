package Hash;

public class Test2 {
    public static void main(String[] args) {
        HashTable2 hash = new HashTable2();

        hash.put(1, "zhang", "张三");
        hash.put(17, "li", "李四");
        hash.put(161, "wang", "王五");
        hash.put(6, "zhao", "赵六");



        //hash.remove(17, "li");


/*        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.next;
        }*/


        hash.remove(1, "zhang");
        HashTable2.Entry pointer = hash.table[1];

        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.next;
        }

    }
}
