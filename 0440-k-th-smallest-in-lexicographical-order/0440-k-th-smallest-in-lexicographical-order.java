class Solution {
    public int Count(long curr,long next,int n){
        int countNum=0;
        while(curr <= n){
            countNum +=Math.min(next,(long) n+1)-curr;

            curr *=10;
            next *= 10;
        }
        return countNum;
    }
    public int findKthNumber(int n, int k) {
        int curr=1;
        k -=1; //since we start from 1st number (1), we need k-1 more numbwer

        while(k>0){
            int count=Count(curr,curr+1,n);
            if(count<=k){
                curr++;
                k -=count; //skiping the number under curr prefix tree
            }
            else{
                curr *=10;
                k -=1;
            }
        }
        return curr;
        
    }
}
