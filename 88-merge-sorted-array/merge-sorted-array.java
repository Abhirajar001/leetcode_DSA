class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;

        while (p2 >= 0) {
            int e1 = (p1 >= 0) ? nums1[p1] : Integer.MIN_VALUE;
            int e2 = nums2[p2];

            if (e1 > e2) {
                nums1[p3] = e1;
                p1--;
            } else {
                nums1[p3] = e2;
                p2--;
            }
            p3--;
        }
    }
}
