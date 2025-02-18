package Exercise;

public class LeetCode09 {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String[] split = s.split("");
        int j = split.length - 1;
        for (int i = 0; i < split.length; i++) {

            if (!split[i].equals(split[j])) {
                return false;
            }
            j--;
        }

        return true;
    }

}
