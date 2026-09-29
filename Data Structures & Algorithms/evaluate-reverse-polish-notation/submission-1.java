class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int int1 = stack.pop();
                int int2 = stack.pop();
                stack.push(int1 + int2);
            } else if (token.equals("-")){
                int int1 = stack.pop();
                int int2 = stack.pop();
                stack.push(int2 - int1);
            } else if (token.equals("*")){
                int int1 = stack.pop();
                int int2 = stack.pop();
                stack.push(int1 * int2);
            } else if (token.equals("/")) {
                int int1 = stack.pop();
                int int2 = stack.pop();
                stack.push(int2/int1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
