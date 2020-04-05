import java.util.Scanner;

public class Lesson1 {
    public static void main (String[] argv) {
        int N = 13;
        String[] names = new String[N];
        String[] favFoods = new String [N];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            System.out.println("Please introduce yourself by saying your name. ");
            String name = sc.nextLine(); //it takes the entire line and doesn't stop at a space. B/c what if somebody wrote their full name w/ a space?
            names[i] = name;

            System.out.println("What is your favorite food? ");
            favFoods[i] = sc.nextLine(); // You can assign the input immediately into the array, or into a local variable that you can add in to the array later. (As seen in the "name" code above. )
        }

        //randomly pick an introducer = A
        int a = (int) (Math.random() * N);

        //randomly pick an introducee = B
        int b = (int) (Math.random() * N);

        //make sure they are not the same person
        while (b == a) {
            b = (int) (Math.random() * N);
        }

        //prompt A to say favFood of B
        System.out.println(names[a] + ", what is the favorite food of " + names[b] + "?");

        //check to see A is correct or not
        String answer = sc.nextLine();
        String correctAns = favFoods[b];


        if (answer.equalsIgnoreCase(correctAns)) {
            System.out.println("Well done! You paid good attention during class and you are correct! ");
        } else {
            System.out.println("Hmm, trying paying more attention. You are incorrect. ");
        }
    }
}
