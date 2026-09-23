class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        // Try every possible substring length
        for (int len = 1; len <= n / 2; len++) {

            // Length must divide the whole string
            if (n % len != 0) {
                continue;
            }

            String part = s.substring(0, len);
            StringBuilder result = new StringBuilder();

            // Repeat the substring
            for (int i = 0; i < n / len; i++) {
                result.append(part);
            }

            // Check if it matches the original string
            if (result.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }
}