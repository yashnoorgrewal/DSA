class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(n, "", 0, 0, list);
        return list;
    }
    private static void backtrack(int n, String s, int open, int close, List<String> list){
        // base condition :-
        if(s.length() == n*2){
            list.add(s);
            return;
        }
        // recursive approach :-
        if(open < n){
            backtrack(n, s + "(", open + 1, close, list);
        }
        if(close < open){
            backtrack(n, s + ")", open, close + 1, list);
        }
    }
}