class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int longestlength = 0;
        for(int i : nums){
            map.put(i, Boolean.FALSE);
        }
        for(int i : nums){
            int currlength = 1;
            //forward check
            int nextnum = i+1;
            while(map.containsKey(nextnum) && map.get(nextnum) == false){
                currlength++;
                map.put(nextnum,Boolean.TRUE);
                nextnum++;
            }
            //backward check
            int prevnum = i-1;
            while(map.containsKey(prevnum) && map.get(prevnum) == false){
                currlength++;
                map.put(prevnum,Boolean.TRUE);
                prevnum--;
            }
            longestlength = Math.max(longestlength, currlength);
        }
        return longestlength;
    }
}