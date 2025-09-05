class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.isEmpty()) return false; //nothing to compare with
                char a = st.pop();
                if(!(ch==')' && a=='(' || ch=='}' && a=='{' || ch==']' && a=='[')){
                    return false;
                }
            }
        }
        return st.isEmpty(); //to check if at the end stack is empty, if not means it hasn't found corresponding openings
    }
}