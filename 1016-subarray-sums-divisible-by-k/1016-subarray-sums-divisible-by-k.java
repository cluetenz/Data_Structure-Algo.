public class SubarraySum {
    //brute force
    //T.C=O(n^3)
    public int bruteForceSubarraysDivByK(int[] nums, int k) {
        
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int l=i;l<j;l++){
                    sum += nums[l];
                }
                if(sum%k==0){
                    count++;
                }
            }
        }
        return count;   
    }
        
    //better approch(using prefix sum concept)
    //T.C=O(n^2)
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        //prefix sum
        for(int i=1;i<n;i++){
            nums[i]=nums[i]+nums[i-1];
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = (i==0)?nums[j]:nums[j]-nums[i-1];
                if(sum%k==0){
                    count++;
                }
            }
        }
        return count;   
    }
        
}

//optimal approch(using HashMap)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        int sum=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=sum%k;
            if(rem<0){
                rem +=k;
            }
            count += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1); 
        }
        return count; 
    }
}
