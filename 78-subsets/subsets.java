class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start){
        result.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++){
            //add the element
            temp.add(nums[i]);
            //backtrack
            backtrack(result, temp, nums, i+1);
            //don't add the element
            temp.remove(temp.size() - 1);
        }
    }
}