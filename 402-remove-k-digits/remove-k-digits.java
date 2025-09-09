class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(char ch : num.toCharArray()){
            while(!st.isEmpty() && k > 0 && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k > 0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        //removing leading zeroes :-
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}