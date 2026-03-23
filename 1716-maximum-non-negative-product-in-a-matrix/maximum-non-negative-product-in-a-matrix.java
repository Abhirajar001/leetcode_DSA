class Solution {
    public int maxProductPath(int[][] grid) {
        final int MOD = 1_000_000_007;
        final int m = grid.length;
        final int n = grid[0].length;

        long[][] dpMin = new long[m][n];
        long[][] dpMax = new long[m][n];

        dpMin[0][0] =dpMax[0][0] = grid[0][0];

        for(int i = 1; i < m; ++i)
            dpMin[i][0] = dpMax[i][0] = dpMin[i-1][0] * grid[i][0];
        for(int j = 1; j < n; ++j)
            dpMin[0][j] = dpMax[0][j] = dpMin[0][j - 1] * grid[0][j];

        for(int i = 1; i < m; ++i){ 
            for(int j = 1;j < n; ++j){ 
                long a = dpMax[i-1][j] * grid[i][j];
                long b = dpMin[i-1][j] * grid[i][j];
                long c = dpMax[i][j-1] * grid[i][j];
                long d = dpMin[i][j-1] * grid[i][j];

                dpMax[i][j] = Math.max(Math.max(a,b), Math.max(c,d));
                dpMin[i][j] = Math.min(Math.min(a,b), Math.min(c,d));
            }
        }
             long ans = dpMax[m-1][n-1];
        return ans < 0 ? -1 : (int)(ans % MOD);
    }
}