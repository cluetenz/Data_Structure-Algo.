class Solution {
    public int maximumSwap(int num) {
        String s=String.valueOf(num);
        int maxRight[]=new int [10];
        for(int i=0;i<10;i++){
            maxRight[i]=-1;
        }
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'0';
            maxRight[idx]=i;
        }

        for(int i=0;i<s.length();i++){
            int currDigit=s.charAt(i)-'0';
            for(int digit=9; digit>currDigit;digit--){
                if(maxRight[digit]>i){
                    //swip
                    char [] charArr=s.toCharArray();
                    char temp = charArr[i];
                    charArr[i] = charArr[maxRight[digit]];
                    charArr[maxRight[digit]] = temp;
                    return Integer.parseInt(new String(charArr));
                }
            }
        }
        return num;
        
    }
}