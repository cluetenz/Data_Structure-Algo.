class MyCircularDeque {

    private int[] deq;         // Array to store deque elements
    private int K;             // Maximum capacity of the deque
    private int front;         // Pointer to the front of the deque
    private int rear;          // Pointer to the rear of the deque
    private int currentCount;  // Current number of elements in the deque

    public MyCircularDeque(int k) {
        K = k;
        deq = new int[K];  
        front = 0;
        rear = K - 1;
        currentCount = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + K) % K;
        deq[front] = value;
        currentCount++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % K;
        deq[rear] = value;
        currentCount++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % K;
        currentCount--;
        return true;  
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + K) % K;
        currentCount--;
        return true;  
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deq[front];  
    }
    
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        return deq[rear];  
    }
    
    public boolean isEmpty() {
        return currentCount == 0; 
    }
    
    public boolean isFull() {
        return currentCount == K;
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