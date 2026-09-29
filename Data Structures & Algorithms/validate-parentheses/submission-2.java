class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pair = new HashMap<>();
        pair.put(']', '[');
        pair.put(')', '(');
        pair.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ']' || c == ')' || c == '}') {
                char open = pair.get(c);
                if (stack.isEmpty()) return false;
                if (stack.pop() != open) return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
