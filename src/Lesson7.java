import java.util.ArrayList;

public class Lesson7 {
    public static void main(String[] argv) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        ArrayList<ArrayList<Character>> cc = new ArrayList<>();
        cc.add(new ArrayList<Character>());
        cc.get(0).add('a');
        cc.get(0).add('b');
        cc.add(new ArrayList<Character>());
        cc.get(1).add('x');
        cc.get(1).add('y');
        cc.get(1).add('z');
        System.out.println(cc);

        String[] sArr = new String[5];
        ArrayList<String> sArrList = new ArrayList<>();

        sArrList.add("abc");
        sArrList.add("def");
        sArrList.add("st");

        System.out.println(sArrList);
        System.out.println(sArrList.get(0));

//        for (int i = 0; i < sArr.length; i++) {
//            System.out.println(sArr[i]);
//        }

        for (int i = 0; i < sArrList.size(); i++) {
            System.out.println("Element at index " + i + ": " + sArrList.get(i));
        }

        sArrList.add(1, "hello");
        System.out.println(sArrList);

        sArrList.add("onemore");
        System.out.println(sArrList);

        sArrList.remove(3);
        System.out.println(sArrList);

        sArrList.remove("hello");
        System.out.println(sArrList);

        System.out.println(arrList);
        arrList.add(6); //auto-boxing
        arrList.add((Integer)3);
        arrList.add(6);
        arrList.add(5);

        System.out.println(arrList);
        // add up all the numbers in the arrList
        int sum = 0;
        for (int i = 0; i < arrList.size(); i++) {
            sum += arrList.get(i);
        }
        System.out.println(sum);

        // arr[0] = 4;
        arrList.set(2, 8);
        System.out.println(arrList);
        System.out.println();
        System.out.println(sArrList);
        sArrList.set(0, "newvalue");
        System.out.println(sArrList);

    }
}
