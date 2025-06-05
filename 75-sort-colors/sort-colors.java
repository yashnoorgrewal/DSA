class Solution {
    public void sortColors(int[] nums) {
        /*prepare an algorithm -
        Case 0 = swap with start, start++ and middle++
        Case 1 = no swap, middle++
        Case 2 = swap with end, end--
        */
        int start = 0, middle = 0, end = nums.length-1;
        while(middle<=end){
            if(nums[middle] == 0){
                int temp = nums[start];
                nums[start] = nums[middle];
                nums[middle] = temp;
                start++;
                middle++;
            }else if(nums[middle] == 1){
                middle++;
            }else if(nums[middle] == 2){
                int temp1 = nums[end];
                nums[end] = nums[middle];
                nums[middle] = temp1;
                end--;
            }
        }
    }
}