//brute force
//T.C:-O(n log n)
//S.C:- O(1)
class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int i=0;
        int j=skill.length-1;
        int s=skill[i]+skill[j];
        long chemistry=0;
        while(i<j){
            int skillSum=skill[i]+skill[j];
            if(s!=skillSum){
                return -1;
            }
            chemistry += (long)(skill[i]*skill[j]);
            i++;
            j--;
        }
        return chemistry;
    }
}

//T.C:- O(n)
//S.C:- O(100000)
class Solution {
    public long dividePlayers(int[] skill) {
        int[] arr=new int[100000];
        int sum=0;
        for(int num:skill){
            sum+=num;
            arr[num]++;
        }
        int teams=skill.length/2;
        if(sum%teams!=0){
            return -1;
        }
        int target=sum/teams;
        long chemistry=0;
        for(int i=0;i<skill.length;i++){
            int currSkill=skill[i];
            int remSkill=target-currSkill;
            if(arr[remSkill]<=0){
                return -1;
            }
            chemistry+=(long)currSkill*(long)remSkill;
            arr[remSkill] -=1;
        }
        return chemistry/2;  
    }
}
