class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //left sorted
            if(nums[start] <= nums[mid]){
                //means if left half is sorted, then check if the target is present in the left sorted half
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            //right sorted
            if(nums[end] >= nums[mid]){
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}