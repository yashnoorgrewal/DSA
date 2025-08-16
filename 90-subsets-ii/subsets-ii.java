class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start){
        list.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            //add the element
            temp.add(nums[i]);
            //backtrack
            backtrack(list, temp, nums, i+1);
            //remove
            temp.remove(temp.size() - 1);
        }
    }
}