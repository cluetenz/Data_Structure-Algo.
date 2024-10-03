class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        int sum=0;
        for(int num:nums){
            sum=(sum+num)%p;
        }
        int target=sum%p;
        if(target==0){
            return 0;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int length=n;
        int curr=0;
        map.put(0,-1);
        for(int j=0;j<n;j++){
            curr=(curr+nums[j])%p;

            int rem=(curr - target+p)%p;
            if(map.containsKey(rem)){
                length=Math.min(length,j-map.get(rem));
            }
            map.put(curr,j);
        }
        return (length==n)?-1:length;
        
    }
}