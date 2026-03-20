class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int r= grid.length;
        int c= grid[0].length;

        int[][] result = new int[r - k +1][c - k +1];
        for(int startRow = 0; startRow <= r - k; startRow++){
            for(int startCol = 0 ; startCol <= c - k; startCol++){

                List<Integer> subgridElements = new ArrayList<>();
                for(int i = startRow; i<startRow + k;i++){
                    for(int j = startCol; j<startCol + k  ;j++){
                        subgridElements.add(grid[i][j]);
                    }
                }
                Collections.sort(subgridElements);
                int minDifference = Integer.MAX_VALUE;
                for(int index =1; index <subgridElements.size();index++){
                    int previousElement = subgridElements.get(index - 1);
                    int currentElement = subgridElements.get(index);

                    if(previousElement != currentElement ){
                        minDifference = Math.min(minDifference, Math.abs(previousElement - currentElement));

                    }
                }
                result[startRow][startCol] = (minDifference == Integer.MAX_VALUE) ? 0 : minDifference;
            }
        } 
        return result;
    }
}