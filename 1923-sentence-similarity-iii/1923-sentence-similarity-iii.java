class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        if(s1.length()<s2.length()){
            String temp=s1;
            s1=s2;
            s2=temp;
        }
        List <String> listS1=new ArrayList<>();
        List <String> listS2=new ArrayList<>();

        listS1=Arrays.asList(s1.split(" "));
        listS2=Arrays.asList(s2.split(" "));

        int i=0 , j=listS1.size()-1;
        int k=0, l=listS2.size()-1;

        //prefix check
        while(k<listS2.size() && i<listS1.size() && listS2.get(k).equals(listS1.get(i))){
            k++;
            i++;
        }
        //postfix check
        while(l>=0 && j>=0 && listS2.get(l).equals(listS1.get(j))){
            l--;
            j--;
        }
        return l<k;
    }
}