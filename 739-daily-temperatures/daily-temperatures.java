class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] result = new int [temperatures.length]; // Default Initialization to 0
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<temperatures.length; i++) {
            while ((!stack.isEmpty()) && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.peek();
                result[j] = i - j;
                stack.pop();
            }
            stack.push(i);
        }

        return result;
    }
}