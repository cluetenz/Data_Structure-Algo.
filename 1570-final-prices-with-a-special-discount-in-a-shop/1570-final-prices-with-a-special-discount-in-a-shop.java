class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int []res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=prices[i];
            for(int j=i+1;j<n;j++){
                if(prices[i]>=prices[j]){
                    res[i]=prices[i]-prices[j];
                    break;
                }
            }
        }
        return res;
    }
}