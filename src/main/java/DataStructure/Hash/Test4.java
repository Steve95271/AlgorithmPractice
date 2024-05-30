package DataStructure.Hash;

public class Test4 {
    public static void main(String[] args) {
        HashTable table = new HashTable();

        for (int i = 0; i < 200000; i++) {
            Object obj = new Object();
            table.put(obj, obj);
        }
        table.print();
    }
}
