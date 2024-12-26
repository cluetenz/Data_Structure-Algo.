//Using map memomization
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

//using array memomization

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int offset = sum;
        int[][] memo = new int[n + 1][2 * sum + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                memo[i][j] = -1;
            }
        }
        
        return solve(nums, 0, 0, target, memo, offset);
    }

    public int solve(int[] nums, int idx, int currSum, int target, int[][] memo, int offset) {
        if (idx == nums.length) {
            return currSum == target ? 1 : 0;
        }

        int adjustedSumIndex = currSum + offset;

        if (memo[idx][adjustedSumIndex] != -1) {
            return memo[idx][adjustedSumIndex];
        }

        int plus = solve(nums, idx + 1, currSum + nums[idx], target, memo, offset);
        int minus = solve(nums, idx + 1, currSum - nums[idx], target, memo, offset);

        memo[idx][adjustedSumIndex] = plus + minus;

        return memo[idx][adjustedSumIndex];
    }
}
