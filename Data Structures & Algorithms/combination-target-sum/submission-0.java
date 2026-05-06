class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {

        }
        
        backtrack(nums, 0, target, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, int target, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList(list));
            return;
        }

        if (target < 0 || index == nums.length) return;
        
        list.add(nums[index]);
        backtrack(nums, index, target - nums[index], list);
        list.remove(list.size() - 1);

        backtrack(nums, index + 1, target, list);
    }
}
