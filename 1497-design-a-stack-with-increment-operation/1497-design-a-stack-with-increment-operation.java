class CustomStack {
    List<Integer> stack;
    List<Integer> increment;
    int maxSize;

    public CustomStack(int maxSize) {
        stack=new ArrayList<>();
        increment=new ArrayList<>();
        this.maxSize=maxSize;  
    }
    
    public void push(int x) {
        if(stack.size()<maxSize){
            stack.add(x);
            increment.add(0);
        }
        
    }
    
    public int pop() {
        if(stack.size()==0){
            return -1;
        }
        int topIdx=stack.size()-1;

        //carry forward the increment to previous element
        if(topIdx>0){
            increment.set(topIdx - 1, increment.get(topIdx - 1) + increment.get(topIdx));
        }
        int popValue=stack.get(topIdx)+increment.get(topIdx);
        stack.remove(topIdx); //remove/pop the top element
        increment.remove(topIdx); //remove the corrsponding element
        return popValue;
    }
    
    public void increment(int k, int val) {
        int n=Math.min(k,stack.size())-1;
            if (n >= 0) {
            increment.set(n, increment.get(n) + val); // Increment the bottom k elements
        } 
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */