//Using memomization
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String,Integer> map=new HashMap<>();
        return solve(nums,0,0,target,map);
    }
    public int solve(int []nums,int idx,int currSum,int target,HashMap<String,Integer> map){
        if(idx==nums.length){
            if(currSum==target){
                return 1;
            }else{
                return 0;
            }
        }
        String key=Integer.toString(idx)+"_"+Integer.toString(currSum);

        if(map.containsKey(key)){
            return map.get(key);
        }
        int plus=solve(nums,idx+1,currSum+nums[idx],target,map);
        int minus=solve(nums,idx+1,currSum-nums[idx],target,map);

        map.put(key, plus + minus);

        return map.get(key);
    }
}