class Solution {
    public int trap(int[] height) {
        int totalwater = 0;
        int[] leftMax = prefixMax(height);
        int[] rightMax = suffixMax(height);
        for(int i = 0; i < height.length; i++){
            if(height[i] < leftMax[i] && height[i] < rightMax[i]){
                totalwater += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return totalwater;
    }
    private static int[] prefixMax(int[] arr){
        int[] ans = new int[arr.length];
        ans[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            ans[i] = Math.max(arr[i], ans[i-1]);
        }
        return ans;
    }
    private static int[] suffixMax(int[] arr){
        int n = arr.length;
        int[] ans = new int[arr.length];
        ans[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            ans[i] = Math.max(arr[i], ans[i+1]);
        }
        return ans;
    }
}