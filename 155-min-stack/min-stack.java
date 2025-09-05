class MinStack {
    private class pair{
        int val;
        int min;

        pair(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    Stack<pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new pair(val,val));
        }else{
            st.push(new pair(val, Math.min(val, st.peek().min)));
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek().val;
        }
        return 0;
    }
    
    public int getMin() {
        if(!st.isEmpty()){
            return st.peek().min;
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */