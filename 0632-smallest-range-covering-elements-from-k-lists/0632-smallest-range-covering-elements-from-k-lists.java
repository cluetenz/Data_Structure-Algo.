//Approch:- using array
//T.C:- O(n*k)
//S.C:- O(k)
//where k=number of list and n=total no. of element across all list
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

//Approch:- Using Heap
//T.C:-O(nlogk) 
//S.C:-O(k)
//where k=number of list and n=total no. of element across all list

class Solution {
    class Element {
        int element;
        int listIndex;
        int elementIndex;

        public Element(int element, int listIndex, int elementIndex) {
            this.element = element;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int n=nums.size();
        //Priority Queue To store Element
        PriorityQueue <Element> pq =new PriorityQueue <>((a,b)-> a.element - b.element);
        int max=Integer.MIN_VALUE;
        int start=-1000000;
        int end= 1000000;

        //inserting first element from each list
        for(int i=0;i<n;i++){
            int element=nums.get(i).get(0);
            pq.offer(new Element(element,i,0));
            max=Math.max(max,element);
        }
        while(!pq.isEmpty()){
            Element curr=pq.poll();
            int min=curr.element;

            if(max-min<end-start){
                start=min;
                end=max; 
            }
            // Move to the next element in the list
            if (curr.elementIndex + 1 < nums.get(curr.listIndex).size()) {
                int nextValue = nums.get(curr.listIndex).get(curr.elementIndex + 1);
                pq.offer(new Element(nextValue, curr.listIndex, curr.elementIndex + 1));
                max = Math.max(max, nextValue);
            } else {
                break; // If any list is exhausted, we stop
            }
        }
        return new int[]{start,end};  
    }
}
