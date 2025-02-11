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