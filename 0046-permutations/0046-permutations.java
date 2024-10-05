class Solution {
    List<List<Integer>> result=new ArrayList<>();
    int n;
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void solve(int idx,int []nums){
        if (idx == n) {
            // Add a copy of the current permutation to the result
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
        }

        for(int i=idx;i<n;i++){
            swap(nums,i,idx);
            solve(idx+1,nums);
            swap(nums,idx,i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n=nums.length;
        solve(0,nums);
        return result;

        
    }
}