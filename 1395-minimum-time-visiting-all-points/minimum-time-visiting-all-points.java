class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime =0;
        for(int i= 1; i<points.length; ++i){
            int[] p1 = points[i-1];
            int[] p2 = points[i];
            int x_diff= Math.abs(p2[1]-p1[1]);
            int y_diff= Math.abs(p2[0]-p1[0]);
            int diff= Math.max(x_diff,y_diff);
            minTime += diff;
        }
        return minTime;
    }
}