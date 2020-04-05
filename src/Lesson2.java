public class Lesson2 {
    public static void main (String[] argv) {
        int [ ] [ ] m = new int [3] [2];
        int value = 1;
//        for (int r = 0; r < m.length; r++) {
//            for (int c = 0; c < m[0].length ; c++) {
//                m [r] [c] = value;
//                value++;
//            }
//        }
//
//        for (int r = 0; r < m.length; r++) {
//            for (int c = 0; c < m[0].length ; c++) {
//                System.out.print(m [r] [c] + "  ");
//            }
//            System.out.println();
//        }
//
//        int sum = 0;
//        for (int r = 0; r < m.length; r++) {
//            for (int c = 0; c < m[0].length ; c++) {
//                sum += m [r] [c];
//            }
//        }
//        System.out.println(sum);
//
//        int[] returnedValues = returnSums(m);
//        for (int i = 0; i < returnedValues.length; i++) {
//            System.out.print(returnedValues[i] + "  ");
//        }
//
//        int[][] mat2 = {{1,2}, {4,8}, {99,2}, {2,13}};
//        System.out.println();
//        returnedValues = returnSums(mat2);
//        for (int i = 0; i < returnedValues.length; i++) {
//            System.out.print(returnedValues[i] + "  ");
//        }
//
//        int columnSum [ ] = new int [m[0].length];
//        for (int c = 0; c < m[0].length; c++) {
//            for (int r = 0; r < m.length ; r++) {
//                columnSum[c] += m[r][c];
//            }
//        }
//
//        System.out.println();
//        for (int i = 0; i < columnSum.length; i++) {
//            System.out.println(columnSum[i] + "  ");
//        }

        String [] [] inputForFunction = {{"dfgh", "bit47byg7tuyb7yr"}, {"ydhvfdy", "fuhdisuf"}, {"ureud", "934iurjhserjh"}};
        int [ ] [ ] strLenMatrix = getLengthOfStrMat(inputForFunction);

        for (int r = 0; r < strLenMatrix.length; r++) {
            for (int c = 0; c < strLenMatrix[r].length; c++) {
                System.out.print(strLenMatrix[r][c] + "  ");
            }
            System.out.println();
        }
    }
    private static int[] returnSums(int[][] m) {
        int[] sums = new int[m.length];
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[0].length ; c++) {
                sums[r] += m[r][c];
            }
        }
        return sums;
    }

    static int [ ] getColumnSums (int [ ] [ ] m) {
        int[] columnSum = new int [m[0].length];
        for (int c = 0; c < m[0].length; c++) {
            for (int r = 0; r < m.length ; r++) {
                columnSum[c] += m[r][c];
            }
        }

        System.out.println();
        for (int i = 0; i < columnSum.length; i++) {
            System.out.println(columnSum[i] + "  ");
        }

        return columnSum;
    }

    static int [ ] [ ] getLengthOfStrMat(String [ ] [ ] strMatrix) {
        int [] [] strLenMat = new int [strMatrix.length] [strMatrix[0].length];
        for (int r = 0; r < strMatrix.length; r++) {
            for (int c = 0; c < strLenMat[r].length; c++) {
                strLenMat [r][c] = strMatrix[r][c].length();
            }
        }
        return strLenMat;
    }
}
