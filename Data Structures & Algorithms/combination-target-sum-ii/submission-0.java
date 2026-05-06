class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recurse(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || index == candidates.length) return;

        //include
        list.add(candidates[index]);
        recurse(candidates, target - candidates[index], index + 1, list);
        list.remove(list.size() - 1);
        
        //exclude
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        
        recurse(candidates, target, index + 1, list);
    }
}
