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