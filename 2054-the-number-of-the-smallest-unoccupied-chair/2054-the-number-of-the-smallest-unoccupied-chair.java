class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n=times.length;
        int targetArrivalTime= times[targetFriend][0];

        int chair[]=new int[n];

        Arrays.sort(times,(a,b)-> a[0]-b[0]);

        for(int []time : times){
            int arrival=time[0];
            int depart=time[1];
            for(int i=0;i<n;i++){
                if(chair[i]<=arrival){
                    chair[i]=depart;
                    if(arrival==targetArrivalTime){
                        return i;
                    }
                    break;
                }
            }
        }
        return -1;
        
    }
}