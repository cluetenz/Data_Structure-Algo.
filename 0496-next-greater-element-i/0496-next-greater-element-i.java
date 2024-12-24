class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();//store element->nextGreater Number
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && st.peek()<nums2[i] ){
                map.put(st.pop(),nums2[i]);

            }
            st.push(nums2[i]);
        }
        while(!st.isEmpty()){
            map.put(st.pop(),-1);
        }
        int result[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int ele=nums1[i];
            result[i]=map.get(ele);

        }
        return result;
    }
}