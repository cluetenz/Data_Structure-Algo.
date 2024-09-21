class Solution {
    private void solve(int curr,int n, List<Integer> result){
        if(curr>n){
            return;
        }
        result.add(curr);

        for(int nextDigit=0;nextDigit<=9;nextDigit++){
            int nextNum=curr*10+nextDigit;
            if(nextNum>n){
                return;
            }
            solve(nextNum,n,result);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();

        for(int num=1;num<=9;num++){
            solve(num,n,res);
        }
        return res;
    }
}