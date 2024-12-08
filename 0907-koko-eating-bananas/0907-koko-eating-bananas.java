//Approch:- Binay Search on Ans
//T.C:- O(nlog(maxValue(num)))
//S.C:- O(1)
class Solution {
    public int maxValue(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }
    public boolean canEat(int []piles,int h, int mid){
        int totalHour=0;
        for(int num:piles){
            int hr=num/mid;
            if(num%mid!=0){
                hr+=1;
            }
            totalHour+=hr;
        }
        return totalHour<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=maxValue(piles);
        while(l<r){
            int mid=l+(r-l)/2;
            if(canEat(piles,h,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;        
    }
}