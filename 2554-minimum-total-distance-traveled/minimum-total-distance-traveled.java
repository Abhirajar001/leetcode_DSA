import java.util.*;

class Solution {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort robots and factories by position
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int r = robot.size();
        int f = factory.length;

        long[][][] dp = new long[r][f][r];
        for (long[][] arr : dp) {
            for (long[] a : arr) {
                Arrays.fill(a, -1);
            }
        }

        return solve(robot, factory, 0, 0, 0, dp);
    }

    private long solve(List<Integer> robot, int[][] factory, int i, int j, int used, long[][][] dp) {

        // All robots repaired
        if (i == robot.size()) return 0;

        // No factories left
        if (j == factory.length) return Long.MAX_VALUE / 2;

        if (dp[i][j][used] != -1) return dp[i][j][used];

        // Option 1: Skip this factory
        long skip = solve(robot, factory, i, j + 1, 0, dp);

        // Option 2: Use this factory
        long use = Long.MAX_VALUE / 2;

        int position = factory[j][0];
        int limit = factory[j][1];

        if (used < limit) {
            use = Math.abs(robot.get(i) - position) +
                  solve(robot, factory, i + 1, j, used + 1, dp);
        }

        return dp[i][j][used] = Math.min(skip, use);
    }
}