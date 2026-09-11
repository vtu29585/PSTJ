import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] a = new int[3];
        int[] b = new int[3];

        // Read Alice's ratings
        for (int i = 0; i < 3; i++) {
            a[i] = sc.nextInt();
        }

        // Read Bob's ratings
        for (int i = 0; i < 3; i++) {
            b[i] = sc.nextInt();
        }

        int alice = 0;
        int bob = 0;

        // Compare ratings
        for (int i = 0; i < 3; i++) {

            if (a[i] > b[i]) {
                alice++;
            } 
            else if (a[i] < b[i]) {
                bob++;
            }
        }

        // Print scores
        System.out.println(alice + " " + bob);

        sc.close();
    }
}