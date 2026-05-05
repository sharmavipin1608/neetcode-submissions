class Solution {
    public int findDuplicate(int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            
            if (nums[index] < 0) return index + 1;

            nums[index] = nums[index] * -1;
        }   

        return 0;
             
    }
}
