class Solution {
    public int singleNumber(int[] nums) {
        //for constant space, we will use XOR here (similar will have 0 and different will have 1). XOR of any number with 0 is the number itself.
        int number = 0;
        for(int i = 0; i < nums.length; i++){
            number = number ^ nums[i];
        }
        return number;
    }
}