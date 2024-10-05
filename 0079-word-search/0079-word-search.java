class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    int n,m;
    public boolean findWord(char[][]board,int i,int j, String word,int idx){
        if(idx==word.length()){
            return true;
        }
        if(i<0 || i>=n || j<0 || j>=m || board[i][j]!=word.charAt(idx) ){
            return false;
        }
        char temp=board[i][j];
        board[i][j]='$';

        for(int []dir:directions){
            int newI=i + dir[0];
            int newJ=j + dir[1];
            if(findWord(board,newI,newJ,word,idx+1)){
                return true;
            }
        }
        board[i][j]=temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        n=board.length;
        m=board[0].length;
        int l=word.length();
        if(m*n<l){
            return false;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0) && findWord(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
}