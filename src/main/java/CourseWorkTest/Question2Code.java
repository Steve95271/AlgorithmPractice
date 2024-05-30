package CourseWorkTest;

public class Question2Code {
    public static void main(String[] args) {
        boolean[][] exampleOne = {{false,true,false,false},
                                  {false,true,false,true},
                                  {true,true,false,true},
                                  {false,true,false,true}};

        boolean[][] exampleTwo = {{true,true,true,false},
                                  {true,true,false,false},
                                  {false,false,true,false},
                                  {false,true,true,true}};


        findStar2(exampleOne);

        System.out.println("------------------");

        //findStar(exampleTwo);


    }

    public static void findStar(boolean[][] array){
        int columnCount = 0;
        int rowCount = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] == false){
                    columnCount = columnCount + 1;
                }
            }

            for (int l = 0; l < array.length; l++) {
                for (int m = 0; m < array.length; m++) {
                    if (array[l][m] == true){
                        rowCount = rowCount + 1;

                    }
                }
                if (columnCount == 4 && rowCount == 3) {
                    if (i == 0) {
                        System.out.println("User A is star");
                    } else if (i == 1) {
                        System.out.println("User B is star");
                    } else if (i == 2) {
                        System.out.println("User C is star");
                    } else if (i == 3) {
                        System.out.println("User D is star");
                    }
                }
                rowCount = 0;
            }

            columnCount = 0;
        }
    }

    public static void findStar2(boolean[][] array) {
        int[] columnCounts = new int[array.length];
        int[] rowCounts = new int[array.length];

        // Calculate column counts
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (!array[j][i]) {
                    columnCounts[i]++;
                }
            }
        }

        // Calculate row counts
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j]) {
                    rowCounts[i]++;
                }
            }
        }

        // Find the "star" user
        for (int i = 0; i < array.length; i++) {
            if (columnCounts[i] == 4 && rowCounts[i] == 3) {
                System.out.println("User " + (char) ('A' + i) + " is star");
            }
        }
    }

}
