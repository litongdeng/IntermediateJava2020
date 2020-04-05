import java.util.Arrays;

public class Lesson2Homework {
    public static void main(String[] argv) {
        String[][] testMat1 = {{"Hey", "Hello", "Good"}, {"Word", "Phrase", "Letter"}};
        String[][] testMat2 = {{"qwerty", "uiop", "kjhgfd"}, {"music", "art", "drawing"}};
        int[] testMat1Values = getTotalCharArray(testMat1);
        int[] testMat2Values = getTotalCharArray(testMat2);
        System.out.println("Writing problem 1 output: ");
        System.out.println("first matrix");
        printArray(testMat1Values);
        System.out.println("second matrix");
        printArray(testMat2Values);

        System.out.println();

        System.out.println("Writing problem 2 output: ");
        int[] testMat1Values_ = columnTotalCharArray(testMat1);
        int[] testMat2Values_ = columnTotalCharArray(testMat2);
        System.out.println("first matrix");
        printArray(testMat1Values_);
        System.out.println("second matrix");
        printArray(testMat2Values_);
    }

    static int[] getTotalCharArray(String[][] strMat) {
        int[] charTotalCountArray = new int[strMat.length];
        int rowSum = 0;
        for (int r = 0; r < strMat.length; r++) {
            for (int c = 0; c < strMat[r].length; c++) {
                int wordLen = strMat[r][c].length();
                rowSum += wordLen;
            }
            charTotalCountArray[r] = rowSum;
            rowSum = 0;
        }
        return charTotalCountArray;
    }

    static int[] columnTotalCharArray(String[][] strMat) {
        int[] columnCharTotalCountArray = new int[strMat[0].length];
        int columnSum = 0;
        for (int c = 0; c < strMat[0].length; c++) {
            for (int r = 0; r < strMat.length; r++) {
                int wordLen = strMat[r][c].length();
                columnSum += wordLen;
            }
            columnCharTotalCountArray[c] = columnSum;
            columnSum = 0;
        }
        return columnCharTotalCountArray;
    }


    static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + "  ");
//        }
    }
}
