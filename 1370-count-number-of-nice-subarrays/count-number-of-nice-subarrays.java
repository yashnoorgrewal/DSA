class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return func(nums, k) - func(nums, k - 1);
    }
    private int func(int[] nums, int k){
        if(k < 0) return 0;
        int l = 0, r = 0;
        int odd = 0, count = 0; // odd = sum
        while(r < nums.length){
            odd += nums[r] % 2;
            while(odd > k){
                odd -= nums[l] % 2;
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
}