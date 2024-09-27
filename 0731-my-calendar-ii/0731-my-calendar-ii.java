class MyCalendarTwo {
    List <int []> calender;
    List<int[]> overlapping;

    public MyCalendarTwo() {
        calender= new ArrayList<>();
        overlapping= new ArrayList<>();
        
    }
    
    public boolean book(int start, int end) {

        //checking for triple booking condition
        for(int[] region:overlapping){
            if(Math.max(region[0],start)<Math.min(region[1],end)){
                return false;
            }
        }

        //checking for double booking and adding the overlapping region
        for(int [] interval:calender){
            if(Math.max(interval[0],start)<Math.min(interval[1],end)){
                int x=Math.max(interval[0],start);
                int y=Math.min(interval[1],end);
                overlapping.add(new int []{x,y});
            }
        }

        calender.add(new int[]{start,end});
        return true;

        
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */