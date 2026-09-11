import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        int n = names.length;

        // Create an array of indexes
        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        // Sort indexes according to height
        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return heights[b] - heights[a];
            }
        });

        // Create result array
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = names[index[i]];
        }

        return result;
    }
}
