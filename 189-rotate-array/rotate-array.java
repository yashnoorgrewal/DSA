class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; //last to first index
        
        //1) reverse the entire array
        reverse(nums,0,n-1);
        //2) reverse first k elements in the array
        reverse(nums,0,k-1);
        //3) reverse the remaining elements in the array
        reverse(nums,k,n-1);
    }
    //reverse function
    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}