//Approch 1:- Brute Force
//T.C:-O(n^2)
//S.C:- O(1)
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

//Approch 2:- Using Monotonic Stack
//T.C:-O(n)
//S.C:-O(n)
class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        Stack<Integer> st=new Stack<>();
        int[] result = prices.clone();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && prices[i]<=prices[st.peek()]){
                result[st.pop()]-=prices[i];
            }
            st.push(i);
        }
        return result;
    }
}
