package CourseWorkTest;

public class Test {
    public static void main(String[] args) {
        boolean[][] boolArray = {{true, true, true},
                                 {false, true, true},
                                 {false, true, false}};

        boolean rowsAllTrue = true;

        for (int i = 0; i < boolArray.length; i++) {
            int countFalse = 0;
            for (int j = 0; j < boolArray[i].length; j++) {
                if (!boolArray[i][j]) {
                    countFalse++;
                }
            }
            if (countFalse >= 2) {
                rowsAllTrue = false;
                break;
            }
        }

        if (rowsAllTrue) {
            System.out.println("All rows have less than two false values.");
        } else {
            System.out.println("At least one row has two or more false values.");
        }
    }
}
