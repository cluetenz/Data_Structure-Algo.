//Approach:- using pointers
//T.C : O(m+n)
//S.C : O(m+n)
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

//approch:- using deque
//T.C:- O(m+n)
//S.C:- O(m+n)
class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        if(s1.length()<s2.length()){
            String temp=s1;
            s1=s2;
            s2=temp;
        }
        Deque<String> deq1 = new LinkedList<>(Arrays.asList(s1.split(" ")));
        Deque<String> deq2 = new LinkedList<>(Arrays.asList(s2.split(" ")));

        //prefix check
        while(!deq1.isEmpty() && !deq2.isEmpty() && deq1.peekFirst().equals(deq2.peekFirst())){
            deq1.pollFirst();
            deq2.pollFirst();
        }
        //postfix check
        while (!deq1.isEmpty() && !deq2.isEmpty() && deq1.peekLast().equals(deq2.peekLast())) {
            deq1.pollLast();
            deq2.pollLast();
        }
        return deq2.isEmpty();
    }
}
