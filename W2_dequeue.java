import java.util.*;

public class W2_dequeue
 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.addLast(num);
            set.add(num);

            // Remove the oldest element when window size exceeds m
            if (deque.size() > m) {
                int removed = deque.removeFirst();

                // Remove from set only if it no longer exists in deque
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }

            // Update maximum when window size is exactly m
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, set.size());
            }
        }

        System.out.println(maxUnique);
        in.close();
    }
}