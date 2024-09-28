class MyCircularDeque {
    private LinkedList<Integer> deq;  // Using LinkedList to store deque elements
    private int cnt;                  // Current number of elements in the deque
    private int k;                    // Maximum capacity of the deque

    public MyCircularDeque(int k) {
        this.k = k;                  
        this.deq = new LinkedList<>(); 
        this.cnt = 0;                  
        
    }
    
    public boolean insertFront(int value) {
        if (cnt == k) {
            return false;              
        }
        deq.addFirst(value);         
        cnt++;                         
        return true;  
    }
    
    public boolean insertLast(int value) {
        if (cnt == k) {
            return false;             
        }
        deq.addLast(value);            
        cnt++;                         
        return true;
        
    }
    
    public boolean deleteFront() {
        if (cnt == 0) {
            return false;             
        }
        deq.removeFirst();             
        cnt--;                         
        return true;
        
    }
    
    public boolean deleteLast() {
        if (cnt == 0) {
            return false;              
        }
        deq.removeLast();             
        cnt--;                         
        return true;
        
    }
    
    public int getFront() {
        if (cnt == 0) {
            return -1;                
        }
        return deq.getFirst();  
        
    }
    
    public int getRear() {
         if (cnt == 0) {
            return -1;             
        }
        return deq.getLast();
        
    }
    
    public boolean isEmpty() {
        return cnt==0; 
    }
    
    public boolean isFull() {
        return cnt==k;  
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */