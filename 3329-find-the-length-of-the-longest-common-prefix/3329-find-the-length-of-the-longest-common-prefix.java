//Approach 1 - Brute Force
//T.C : O(m⋅log10​M + n⋅log10​N)
//S.C : O(m⋅log10​M)
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set <Integer> st=new HashSet<>();

        for(int num:arr1){
            while(!st.contains(num) && num>0){
                st.add(num);
                num /= 10;
            }
        }
        int count=0;
        for(int num:arr2){
            while(!st.contains(num) && num>0){
                num /= 10;
            }
            if(num>0){
                count = Math.max(count,(int) Math.log10(num)+1);
            }
        }
        return count;
        
    }
}
//Approch 2
//using trie(prefix Tree)
//Time Complexity :- 0(m*d+n*d) where m and n is length of arr1 and arr2 respectively and d is length of word or number
//space Complexity :- 0(m*d)
class Solution {
    static class trieNode{
        trieNode []child;
        trieNode(){
            child=new trieNode[10];
        }
    }

    public void insert(int num,trieNode root) {
        trieNode curr=root;
        String numStr=Integer.toString(num);
        for(int i=0;i<numStr.length();i++){
            int idx=numStr.charAt(i)-'0';
            if(curr.child[idx]==null){
                curr.child[idx]= new trieNode();
            }
            curr=curr.child[idx];
        }   
    }

    public int search(int num, trieNode root) {
        trieNode curr = root;
        String numStr = Integer.toString(num);
        int length = 0;

        for(int i=0;i<numStr.length();i++){
            int idx=numStr.charAt(i)-'0';
            if (curr.child[idx] != null) {
                length++;
                curr = curr.child[idx];
            } else {
                break;
            }
        }
        return length;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        trieNode root=new trieNode();

        for (int num : arr1) {
            insert(num, root);
        }

        int result = 0;
        for (int num : arr2) {
            result = Math.max(result, search(num, root));
        }
        return result;    
    }
}
