import java.util.*;

public class Main {

    public static void matrixRotation(int[][] matrix, int r) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int layers = Math.min(rows, cols) / 2;

        for (int layer = 0; layer < layers; layer++) {

            ArrayList<Integer> list = new ArrayList<>();

            int top = layer;
            int bottom = rows - 1 - layer;
            int left = layer;
            int right = cols - 1 - layer;

            // Top row
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                list.add(matrix[bottom][j]);
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                list.add(matrix[i][left]);
            }

            // Number of useful rotations
            int rotation = r % list.size();

            // Put rotated values back
            int index = rotation;

            // Top row
            for (int j = left; j <= right; j++) {
                matrix[top][j] = list.get(index);
                index = (index + 1) % list.size();
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = list.get(index);
                index = (index + 1) % list.size();
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                matrix[bottom][j] = list.get(index);
                index = (index + 1) % list.size();
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                matrix[i][left] = list.get(index);
                index = (index + 1) % list.size();
            }
        }

        // Print matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int r = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        matrixRotation(matrix, r);

        sc.close();
    }
}
