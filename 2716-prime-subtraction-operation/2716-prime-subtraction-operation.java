import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                continue;
            }
            for(int p=2;p<nums[i];p++){
                if(!isPrime(p)){
                    continue;
                }
                if(nums[i]-p<nums[i+1]){
                    nums[i]-=p;
                    break;
                }
            }
            if(nums[i]>=nums[i+1]){
                return false;
            }

        }
        return true;
    }
}
