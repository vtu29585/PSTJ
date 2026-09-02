import java.io.*;

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Odd or Even
    public PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    // Prime or Composite
    public PerformOperation isPrime() {
        return n -> {
            if (n < 2) {
                return false;
            }

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        };
    }

    // Palindrome or Not Palindrome
    public PerformOperation isPalindrome() {
        return n -> {
            int original = n;
            int reversed = 0;

            while (n > 0) {
                reversed = reversed * 10 + n % 10;
                n /= 10;
            }

            return original == reversed;
        };
    }
}

interface PerformOperation {
    boolean check(int a);
}

public class W1_lambda {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        PerformOperation op;
        boolean ret;
        String ans;

        while (T-- > 0) {
            String[] input = br.readLine().trim().split("\\s+");

            int ch = Integer.parseInt(input[0]);
            int num = Integer.parseInt(input[1]);

            if (ch == 1) {
                op = ob.isOdd();
                ret = MyMath.checker(op, num);
                ans = ret ? "ODD" : "EVEN";

            } else if (ch == 2) {
                op = ob.isPrime();
                ret = MyMath.checker(op, num);
                ans = ret ? "PRIME" : "COMPOSITE";

            } else {
                op = ob.isPalindrome();
                ret = MyMath.checker(op, num);
                ans = ret ? "PALINDROME" : "NOT PALINDROME";
            }

            System.out.println(ans);
        }
    }
}