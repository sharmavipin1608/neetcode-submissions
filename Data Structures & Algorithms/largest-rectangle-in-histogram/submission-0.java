class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        Deque<int[]> stack = new ArrayDeque<>(); //index, height
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int current = heights[i];
            int start = i;

            while (!stack.isEmpty() && stack.peek()[1] > current) {
                int[] top = stack.pop();
                maxArea = Math.max(maxArea, top[1] * (i - top[0]));
                start = top[0];
            }

            stack.push(new int[] {start, current});
        }    
        
        int index = heights.length;
        for (int[] element : stack) {
            maxArea = Math.max(maxArea, element[1] * (index - element[0]));
        }

        return maxArea;
    }
}
