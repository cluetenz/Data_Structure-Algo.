class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int [] cumCount=new int[nums.length];
        cumCount[0]=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]%2==nums[i-1]%2){
                cumCount[i]=cumCount[i-1]+1;
            }else{
                cumCount[i]=cumCount[i-1];
            }
        }
        boolean [] res=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            if(cumCount[end]-cumCount[start]==0){
                res[i]=true;
            }else{
                res[i]=false;
            }
        }
       return res; 
    }
}