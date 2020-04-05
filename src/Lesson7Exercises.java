import java.util.ArrayList;

public class Lesson7Exercises {
    public static void main (String[] argv) {
        //given an input array of integers, put all numbers into an ArrayList
        //with the original order
        int[] intArray = new int[5];
        intArray[0] = 1;
        intArray[1] = 7;
        intArray[2] = 99;
        intArray[3] = 678;
        intArray[4] = 0;

        ArrayList<Integer> intArrList = new ArrayList<>();
        for (int i = 0; i < intArray.length; i++) {
            intArrList.add(intArray[i]);
        }

        System.out.println(intArrList);

        // given an arraylist, create a second arraylist, put all numbers from
        // list 1 to to list 2 in reverse order

        ArrayList<Integer> intArrList2 = new ArrayList<>();
        for (int i = intArrList.size() - 1; i >= 0; i--) {
            intArrList2.add(intArrList.get(i));
        }

        System.out.println(intArrList2);
    }
}
