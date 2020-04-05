import java.util.ArrayList;

public class Lesson7Homework {
    public static void main(String[] argv) {
        // Given an ArrayList of Strings, remove all elements (Strings) longer than 3 characters
        ArrayList<String> strArrList = new ArrayList<>();
        strArrList.add("Litong");
        strArrList.add("ab");
        strArrList.add("Java");
        strArrList.add("C++");
        strArrList.add("Ruby!");
        System.out.println("Practice 3");
        System.out.println(strArrList);
        for (int i = 0; i < strArrList.size(); i++) {
            if (strArrList.get(i).length() > 3) {
                strArrList.remove(i);
            }
        }
        System.out.println(strArrList);

        System.out.println();
        System.out.println("Practice 4");
        // Given an ArrayList of characters, change all elements to be its next
        // characters, for ‘z’, change it to ‘a’. For example: [‘c’, ‘m’,’z’, ‘b’]->[‘d’, ‘n’,’a’, ‘c’]
        ArrayList<Character> charArrayList = new ArrayList<>();
        charArrayList.add('L');
        charArrayList.add('r');
        charArrayList.add('V');
        charArrayList.add('d');
        charArrayList.add('m');
        charArrayList.add('z');
        charArrayList.add('Z');
        System.out.println(charArrayList);
        for (int i = 0; i < charArrayList.size(); i++) {
            if (charArrayList.get(i) == 'z') {
                charArrayList.set(i, 'a');
            } else if (charArrayList.get(i) == 'Z') {
                charArrayList.set(i, 'A');
            } else {
                charArrayList.set(i, (char) (charArrayList.get(i) + 1));
            }
        }
        System.out.println(charArrayList);

        System.out.println();
        System.out.println("Homework Problem 1");
        ArrayList<Integer> intArr1 = new ArrayList<>();
        intArr1.add(0);
        intArr1.add(23);
        intArr1.add(444);
        intArr1.add(-9);
        intArr1.add(0);
        System.out.println(intArr1);
        System.out.println(removeAllZeros(intArr1));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        ArrayList<Integer> intArr2 = new ArrayList<>();
        intArr2.add(-69);
        intArr2.add(78);
        intArr2.add(420);
        intArr2.add(13);
        System.out.println(intArr2);
        System.out.println(removeAllZeros(intArr2));

        System.out.println();
        System.out.println("HW Problem 2");
        System.out.println(intArr1);
        System.out.println(doubleEverything(intArr1));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(intArr2);
        System.out.println(doubleEverything(intArr2));

        System.out.println();
        System.out.println("HW Problem 3");
        String[] strArr = {"J Perm", "jujube", "Litong", "liyjfjjj"};
        System.out.println(JIndex(strArr));
    }
    static ArrayList<Integer> removeAllZeros(ArrayList<Integer> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) == 0) {
                arrList.remove(i);
            }
        }
        return arrList;
    }

    static ArrayList<Integer> doubleEverything(ArrayList<Integer> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            arrList.set(i, arrList.get(i) * 2);
        }
        return arrList;
    }

    static ArrayList<Integer> JIndex(String[] arr) {
        ArrayList<Integer> returnArrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].toLowerCase();
            if (arr[i].indexOf('j') == -1) {
                returnArrList.add(arr[i].indexOf('j'));
            } else {
                returnArrList.add(arr[i].indexOf('j') + 1);
            }
        }
        return returnArrList;
    }
}
