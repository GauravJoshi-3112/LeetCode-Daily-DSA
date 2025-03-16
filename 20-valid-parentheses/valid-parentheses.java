class Solution {
    public boolean isValid(String s) {
        // Maintaining a Stack for Brackets
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            // Iterating Every Element of the Character Array
            if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                if (ch == ')' && stack.pop()!='(') return false;
                if (ch == ']' && stack.pop()!='[') return false;
                if (ch == '}' && stack.pop()!='{') return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}