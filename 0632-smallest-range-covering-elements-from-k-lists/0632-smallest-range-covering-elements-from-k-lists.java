class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n=nums.size();
        int arr []=new int[n];
        int resultRange []={-1000000,1000000}; //(a,b)

        while(true){
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            int minEleListIdx=0;

            for(int i=0;i<n;i++){
                int listIdx=i;
                int eleIdx=arr[i];
                int ele=nums.get(listIdx).get(eleIdx);

                if(ele<min){
                    min=ele;
                    minEleListIdx=i;
                }
                if(ele>max){
                    max=ele;
                }
            }
            if((max-min)<resultRange[1]-resultRange[0]){
                resultRange[1]=max;
                resultRange[0]=min;
            }
            int nextIdx=arr[minEleListIdx]+1;
            if(nextIdx >= nums.get(minEleListIdx).size()){
                break;
            }
            arr[minEleListIdx] = nextIdx; // Move to the next element in the list
        }
        return resultRange;  
    }
}