import java.util.*;

public class W7_gradingstudents {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            int grade = sc.nextInt();

            if (grade < 38) {
                System.out.println(grade);
            } else {

                int next = ((grade / 5) + 1) * 5;

                if (next - grade < 3) {
                    System.out.println(next);
                } else {
                    System.out.println(grade);
                }
            }
        }

        sc.close();
    }
}