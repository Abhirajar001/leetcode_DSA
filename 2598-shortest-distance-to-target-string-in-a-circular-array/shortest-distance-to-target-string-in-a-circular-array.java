class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = n;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int directDistance = Math.abs(i - startIndex);
                int wrapAroundDistance = n - directDistance;
                minDistance = Math.min(minDistance, Math.min(directDistance, wrapAroundDistance));
            }
        }

        return minDistance == n ? -1 : minDistance;
    }
}