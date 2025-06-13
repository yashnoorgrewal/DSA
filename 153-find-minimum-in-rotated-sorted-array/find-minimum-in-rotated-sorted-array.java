class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= nums[start]){
                ans = Math.min(ans, nums[start]);
                start = mid + 1;
            }else if(nums[mid] <= nums[end]){
                ans = Math.min(ans, nums[mid]);
                end = mid - 1;
            }
        }
        return ans;
    }
}