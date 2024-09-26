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

//approch:- using order set
//Time complexity:- O(nlogn)
//Space complexity :- O(n)
class MyCalendar {
    TreeSet<int []> calendar;

    public MyCalendar() {
        calendar = new TreeSet<>((a, b) -> a[0] - b[0]);  // Sort by start time   
    }
    
    public boolean book(int start, int end) {
       int[] newEvent = {start, end};

       // Find the event that starts just before or at the same time as the new event
        int[] lower = calendar.floor(newEvent);

        // Find the event that starts just after or at the same time as the new event
        int[] higher = calendar.ceiling(newEvent);

        // Check for overlap with the lower event
        if (lower != null && lower[1] > start) {
            return false;
        }
        
        // Check for overlap with the higher event
        if (higher != null && higher[0] < end) {
            return false;
        }
        
        // No overlap, add the new event
        calendar.add(newEvent);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
