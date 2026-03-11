class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0){
            return 1;
        }
        List<Integer> list =new ArrayList<>();
        while(n!=0){
            list.add(n&1);
            n>>=1;
        }
        int result =0;
        int exp = list.size()-1;
        for(int i = list.size() - 1; i >=0; i--){
            if(list.get(i)==0){
                result +=(int) Math.pow(2, exp);
            }
            exp--;
        }
        return result;
        
    }
}