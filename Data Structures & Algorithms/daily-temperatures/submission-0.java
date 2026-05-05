class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (null == temperatures || temperatures.length == 0) return new int[0];

        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();  //index

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }
        return result;    
    }
}
