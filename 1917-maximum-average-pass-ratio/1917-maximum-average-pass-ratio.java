class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n=classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for(int i=0;i<n;i++){
            double currPR=(double)classes[i][0]/classes[i][1];
            double newPR=(double)(classes[i][0]+1)/(classes[i][1]+1);
            double changeInPR=newPR-currPR;
            pq.offer(new double[]{changeInPR,i});
        }

        while(extraStudents-->0){
            double[] curr=pq.poll();
            int idx=(int)curr[1];

            //updating classes array
            classes[idx][0]++;
            classes[idx][1]++;

            double currPR=(double)classes[idx][0]/classes[idx][1];
            double newPR=(double)(classes[idx][0]+1)/(classes[idx][1]+1);
            double changeInPR=newPR-currPR;
            pq.offer(new double[]{changeInPR,idx});
        }

        double result=0.0;
        for(int i=0;i<n;i++){
            result+= (double)classes[i][0]/classes[i][1];
        }
        return result/n;
    }
}