import java.util.*;

public class W2 hashset
{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String first = scanner.next();
            String second = scanner.next();

            // Combine both strings to represent a pair
            String pair = first + " " + second;

            set.add(pair);

            // Print number of unique pairs
            System.out.println(set.size());
        }

        scanner.close();
    }
}
