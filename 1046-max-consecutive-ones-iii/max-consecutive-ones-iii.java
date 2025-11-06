class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int maxl = 0, zeroes = 0;
        while(r < n){
            if(nums[r] == 0) zeroes++;
            while(zeroes > k){
                if(nums[l] == 0) zeroes--;
                l++;
            }
            if(zeroes <= k){
                maxl = Math.max(maxl, r-l+1);
            }
            r++;
        }
        return maxl;
    }
}