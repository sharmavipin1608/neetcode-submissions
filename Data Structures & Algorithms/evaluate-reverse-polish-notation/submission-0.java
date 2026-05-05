class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();

                if (str.equals("+")) {
                    stack.push(first + second);
                } else if(str.equals("-")) {    
                    stack.push(first - second);
                } else if(str.equals("*")) {
                    stack.push(first * second);
                } else if(str.equals("/")) {
                    stack.push(first / second);
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }    

        return stack.pop();
    }
}
