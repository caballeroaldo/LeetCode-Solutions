class MyQueue {
    
    private Stack<Integer> pop;
    private Stack<Integer> push;
    
    public MyQueue() {
        pop = new Stack<>();
        push = new Stack<>();
    }
   
    private int front;
    
    public void push(int x) {
        if(push.isEmpty()) {
            front = x;
        }
        push.push(x);
    }
    
    public int pop() {
        if(pop.isEmpty()) {
            while(!push.isEmpty()) {
                pop.push(push.pop());
            }
        }
        return pop.pop();
    }
    
    public int peek() {
        if(!pop.isEmpty()) {
            return pop.peek();
        }
        return front;
    }
    
    public boolean empty() {
        return pop.isEmpty() && push.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */