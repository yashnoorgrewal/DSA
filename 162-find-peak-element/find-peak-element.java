class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        // initial checks :-
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int s = 1;
        int e = n-2;
        while(s <= e){
            int m = s + (e-s) / 2;
            if(nums[m] > nums[m-1] && nums[m] > nums[m+1]){
                return m;
            }else if(nums[m] > nums[m-1]){
                //if mid is on increasing curve, peak is at right
                s = m + 1;
            }else if(nums[m] > nums[m+1]){
                //if mid is on decreasing curve, peak is on left
                e = m - 1;
            }else{
                //this is basically for "multiple peaks" case, even if the above conditions are not satisfied, still if we'll consider any side we would be getting a peak. Let us continue with the right side
                s = m + 1;
            }
        }
        return -1;
    }
}