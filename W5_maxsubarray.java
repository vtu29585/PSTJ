import java.util.*;

public class W5_maxsubarray {

    static int[] maxSubarray(int[] arr) {

        int maxSubarray = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSubarray = Math.max(maxSubarray, currentSum);
        }

     
        int maxSubsequence = 0;
        int largest = arr[0];

        for (int x : arr) {
            if (x > 0) {
                maxSubsequence += x;
            }

            largest = Math.max(largest, x);
        }

        if (maxSubsequence == 0) {
            maxSubsequence = largest;
        }

        return new int[]{maxSubarray, maxSubsequence};
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] result = maxSubarray(arr);

            System.out.println(result[0] + " " + result[1]);
        }

        sc.close();
    }
}
