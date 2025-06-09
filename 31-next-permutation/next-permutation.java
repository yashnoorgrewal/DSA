class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int gola_index = -1;

        //Find the first decreasing element from the end
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                gola_index = i - 1;
                break;
            }
        }

        //If found, find the just larger element to the right and swap
        if (gola_index != -1) {
            int swap_index = gola_index;
            for (int j = n - 1; j > gola_index; j--) {
                if (nums[j] > nums[gola_index]) {
                    swap_index = j;
                    break;
                }
            }
            int temp = nums[gola_index];
            nums[gola_index] = nums[swap_index];
            nums[swap_index] = temp;
        }

        //reverse what is all there on the right side of gola_index (i-1)
        int start = gola_index + 1;
        int end = n - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}