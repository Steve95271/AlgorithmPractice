package CourseWorkTest;

public class Question2Code2 {
    public static void main(String[] args) {
        boolean[][] array = {{false,false,false,false},
                             {true,false,true,true},
                             {true,true,false,true},
                             {true,true,true,false}};




        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        boolean trueIndex = true;

        int columnCount = 0;
        int rowCount = 0;
        int j;
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (j = 0; j < array.length; j++) {
                if (array[j][i] == false){
                    columnCount = columnCount + 1;
                }
                if (array[i][j] == true){
                    rowCount = rowCount + 1;

                }
            }
            if (columnCount == 4) {
                if (i == 0) {
                    System.out.println("User A follows no one");
                } else if (i == 1) {
                    System.out.println("User B follows no one");
                } else if (i == 2) {
                    System.out.println("User C follows no one");
                } else if (i == 3) {
                    System.out.println("User D follows no one");
                }
            }
            columnCount = 0;
            rowCount = 0;
        }

        System.out.println(columnCount);
    }
}
