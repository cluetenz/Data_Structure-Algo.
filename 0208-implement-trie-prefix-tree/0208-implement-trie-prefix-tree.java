class Trie {
    static class trieNode{
        trieNode []child;
        boolean isEndOfWord;

        trieNode(){
            child=new trieNode[26];
            isEndOfWord=false;
        }
    }
    private trieNode root;

    public Trie() {
        root=new trieNode();  
    }
    
    public void insert(String word) {
        trieNode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i) - 'a';
            if(curr.child[idx]==null){
                curr.child[idx]= new trieNode();
            }
            curr=curr.child[idx];
        }
        curr.isEndOfWord=true;    
    }
    
    public boolean search(String word) {
        trieNode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i) - 'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
        }
        return ( curr!=null && curr.isEndOfWord ); 
    }
    
    public boolean startsWith(String prefix) {
        trieNode curr=root;
        int count=0;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i) - 'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
            count++;
        }
        return count==prefix.length(); 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */