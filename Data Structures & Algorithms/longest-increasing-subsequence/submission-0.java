class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            int index = Collections.binarySearch(result, num);

            if (index < 0) {
                int insertionPoint = -(index + 1);
                if (insertionPoint == result.size()) {
                    result.add(num);
                } else {
                    result.set(insertionPoint, num);
                }
            }
        }

        return result.size();
    }
}
