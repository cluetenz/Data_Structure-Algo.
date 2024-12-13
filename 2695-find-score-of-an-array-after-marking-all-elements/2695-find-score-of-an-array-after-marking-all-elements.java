
//Approch:-Using sorting array with indix 
class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        int [][]arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        boolean visited[]=new boolean[n];
        long score=0;
        for(int i=0;i<n;i++){
            int value=arr[i][0];
            int idx=arr[i][1];
            if (!visited[idx]) {
                score += value;
                visited[idx] = true;
                
                if (idx + 1 < n) visited[idx + 1] = true;
                if (idx - 1 >= 0) visited[idx - 1] = true;
            }
        }
        return score;
    }
}

//Approch:- Using Priority Queue
//T.C:-O(nlogn)
//S.C:-0(n)

class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]==b[0])?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});
        }
        long score=0;
        boolean []visited=new boolean [n];
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int value=arr[0];
            int idx=arr[1];
            if(!visited[idx]){
                score+=value;
                if(idx+1<n){
                    visited[idx+1]=true;
                }
                if(idx-1>=0){
                    visited[idx-1]=true;
                }
            }
        }
        return score;
    }
}
