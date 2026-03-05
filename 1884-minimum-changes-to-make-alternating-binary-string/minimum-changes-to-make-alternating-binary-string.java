class Solution {
    public int minOperations(String s) {
        int cnt =0;
        int n = s.length();
        for(int i =0;i<n; ++i){ 
            if(s.charAt(i) != "01".charAt(i & 1)){
            cnt++;
            }
        }
        return Math.min(cnt, n -cnt);
    }
}