class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastseen = new int[]{-1, -1, -1};
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';
            lastseen[idx] = i;
            if(lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1){
                int minlastseen = Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));
                count += minlastseen + 1;
            }
        }
        return count;
    }
}