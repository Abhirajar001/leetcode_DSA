public class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean down = false;

        for (char c : s.toCharArray()) {
            rows[row].append(c);
            if (row == 0 || row == numRows - 1) {
                down = !down;
            }
            row += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println("Example 1 Output: " + solution.convert(s1, numRows1));

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println("Example 2 Output: " + solution.convert(s2, numRows2));

        String s3 = "A";
        int numRows3 = 1;
        System.out.println("Example 3 Output: " + solution.convert(s3, numRows3));
    }
}