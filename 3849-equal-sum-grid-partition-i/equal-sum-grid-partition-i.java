class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        long totalSum = 0;
        long[] rowSums = new long[m];
        long[] colSums = new long[n];
        
        // Calculate total sum and individual row/column sums in one pass
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                totalSum += val;
                rowSums[i] += val;
                colSums[j] += val;
            }
        }
        
        // If total sum is odd, it cannot be split into two equal integers
        if (totalSum % 2 != 0) {
            return false;
        }
        
        long target = totalSum / 2;
        
        // Check horizontal cuts (between rows)
        long rowPrefix = 0;
        for (int i = 0; i < m; i++) {
            rowPrefix += rowSums[i];
            // Must not be the last row to ensure both sections are non-empty
            if (rowPrefix == target && i != m - 1) {
                return true;
            }
        }
        
        // Check vertical cuts (between columns)
        long colPrefix = 0;
        for (int j = 0; j < n; j++) {
            colPrefix += colSums[j];
            // Must not be the last column to ensure both sections are non-empty
            if (colPrefix == target && j != n - 1) {
                return true;
            }
        }
        
        return false;
    }
}   