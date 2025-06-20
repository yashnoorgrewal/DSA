class Solution {
    public int maxDepth(String s) {
        int maxdepth = 0;
        int currmax = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                currmax++;
                if(currmax > maxdepth){
                    maxdepth = currmax;
                }
            }else if(c == ')'){
                currmax--;
            }
        }
        return maxdepth;
    }
}