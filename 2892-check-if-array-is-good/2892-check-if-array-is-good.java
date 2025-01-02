class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int max=maxmum(nums);
        if(n!=max+1){
            return false;
        }
        Map <Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= max - 1; i++) {
            if (map.getOrDefault(i,0) != 1) {
                return false;
            }
        }
        
        return map.getOrDefault(max,0)==2;
    }
    public int maxmum(int []arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}