//Approch:-Brute Force
//T.C:-O(N^2)
//S.C:- 
class Solution {
    public String removeOccurrences(String s, String part) {
        int l=part.length();
        StringBuilder sb=new StringBuilder (s);
        int i=0;
        while (i <= sb.length() - l) { 
            if (sb.substring(i, i + l).equals(part)) {
                sb.delete(i, i + l); 
                i = 0;
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
//Approch:-Using indexOf() operation
//T.C:-O(n^2/m)
class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf(part) != -1) {
            sb.delete(sb.indexOf(part), sb.indexOf(part) + part.length());
        }
        return sb.toString();
    }
}
