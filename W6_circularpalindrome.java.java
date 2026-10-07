import java.util.*;

public class Main {

    // Find longest palindromic substring length
    static int longestPalindrome(String s) {
        int max = 1;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            int len1 = expand(s, i, i);

            // Even length palindrome
            int len2 = expand(s, i, i + 1);

            max = Math.max(max, Math.max(len1, len2));
        }

        return max;
    }

    // Expand around the center
    static int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        // Generate all rotations
        for (int i = 0; i < n; i++) {

            String rotation = s.substring(i) + s.substring(0, i);

            int answer = longestPalindrome(rotation);

            System.out.println(answer);
        }

        sc.close();
    }
}