class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int []ans =new int[n];
        //Arrays.fill(ans,0);
        if(k==0){
            return ans;
        }
        for(int i=0;i<n;i++){
            if(k>0){
                for(int j=i+1;j<=i+k;j++){
                    ans[i] +=code[j%n];
                }    
            }
            else{
                for(int j=i-Math.abs(k);j<i;j++){
                    ans[i] +=code[(j+n)%n];
                }
            }
        }
        return ans;    
    }
}