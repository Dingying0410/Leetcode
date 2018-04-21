class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> queue1;
    int peek = -1;
    
    public MyStack() {
        queue1 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
        peek = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue1.size();
        while (size-- > 1) {
            peek = queue1.peek();
            queue1.offer(queue1.poll());
        }
        return queue1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return peek;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */