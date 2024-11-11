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

//Approch 2
import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean []prime=new boolean[1000];
    public void isPrime() {
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        for (int i = 2; i * i <= 1000; i++) {
            if (prime[i]) {
                for (int j = i * i; j < 1000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
    
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        isPrime();
        
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                continue;
            }
            for(int p=2;p<nums[i];p++){
                if(!prime[p]){
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
