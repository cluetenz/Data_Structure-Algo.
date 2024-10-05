class Solution {
    List<List<Integer>> result=new ArrayList<>();
    Set<Integer> st = new HashSet<>();
    int n;
    public void solve(int []nums,List<Integer> temp){
        if(temp.size()==n){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            if(!st.contains(nums[i])){
                temp.add(nums[i]);
                st.add(nums[i]);
                solve(nums,temp);
                //backtrack
                st.remove(nums[i]);
                temp.remove(temp.size() - 1);

            }

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        n=nums.length;
        List<Integer> temp=new ArrayList<>();
        solve(nums,temp);
        return result;
    }
}