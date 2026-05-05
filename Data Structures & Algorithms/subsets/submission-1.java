class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return result;
        
        recurse(nums, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        //include
        list.add(nums[index]);
        recurse(nums, index + 1, list);
        list.remove(list.size() - 1);

        //exclude
        recurse(nums, index + 1, list);
    }
}
