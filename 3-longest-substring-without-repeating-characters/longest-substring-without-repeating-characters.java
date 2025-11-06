class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window :-
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxl = 0;
        int l = 0, r = 0;
        while(r < n){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                l = Math.max(l, map.get(ch) + 1);
            }
            map.put(ch, r);
            int len = r - l + 1;
            maxl = Math.max(maxl, len);
            r++;
        }
        return maxl;
    }
}