package DataStructure.Hash;

public class Test {
    public static void main(String[] args) {
        String s1 = "abc";

        // 生成哈希码原则：值相同的字符串生成相同的hash码， 尽量让值不同的字符串生成不同的hash码
        /*
        对于 abc, a * 100 + b * 10 + c
        对于 bac, b * 100 + b * 10 + c
         */

        int hash = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            System.out.println((int) c);
            //hash = hash * 10 + c;
            //乘以质数可以减少hash冲突，质数选择31
            //hash = hash * 31 + c;
            //为了提升运算效率，可以把乘法改成左移运算
            hash = (hash << 5) + c; //左移5位等同于乘以31
        }

        System.out.println(hash);
    }
}
