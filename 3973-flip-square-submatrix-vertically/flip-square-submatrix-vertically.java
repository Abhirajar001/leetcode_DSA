class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i = x; i < x + k/2;i++ ){
            int a = x + k - 1 - (i - x);
            for(int j = y; j<y+k;j++){
                int temp =grid[i][j];
                grid[i][j] = grid[a][j];
                grid[a][j] = temp;
            }
        }
        return grid;
    }
}