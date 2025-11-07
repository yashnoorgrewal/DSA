class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int maxl = 0;
        int maxf = 0;
        int[] count = new int[26];
        while(r < s.length()){
            char ch = s.charAt(r);
            count[ch - 'A']++;
            maxf = Math.max(maxf, count[ch - 'A']);
            if((r-l + 1) - maxf > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            maxl = Math.max(maxl, r-l + 1);
            r++;
        }
        return maxl;
    }
}