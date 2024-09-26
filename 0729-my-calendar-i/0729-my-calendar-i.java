//Brute force approch
//Time complexity:- O(n^2)
//Space complexity :- O(n)
class MyCalendar {
    List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();   
    }
    
    public boolean book(int start, int end) {
        for (int[] curr : calendar) {
            if (start < curr[1] && end > curr[0]) {  // Check if there's overlap
                return false;
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
