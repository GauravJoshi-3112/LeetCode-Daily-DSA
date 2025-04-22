class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> op = new Stack<>();
        int score = 0;
        for(int i=0; i<operations.length; i++) {
            if (operations[i].equals("C")) {
                score = score - op.pop();
            } else if (operations[i].equals("D")) {
                op.push(op.peek()*2);
                score += op.peek();
            } else if (operations[i].equals("+")) {
                int num1 = op.pop();
                int num2 = op.pop();
                op.push(num2);
                op.push(num1);
                op.push(num1+num2);
                score += op.peek();
            } else {
                op.push(Integer.valueOf(operations[i]));
                score += op.peek();
            } 
        }
        return score;
    }
}