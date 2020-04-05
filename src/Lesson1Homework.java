import java.util.Scanner;

public class Lesson1Homework {
    public static void main (String[] argv) {
        // Print "I" from asterisks
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a number. ");
        int n = sc.nextInt();
        int middle = n / 2;

        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < middle; x++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }

        System.out.println();
        System.out.println();
        // Print "T" from asterisks
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < middle; x++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }
}
