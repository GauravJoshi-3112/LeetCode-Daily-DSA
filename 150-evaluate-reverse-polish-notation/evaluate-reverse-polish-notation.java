class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> tokenStack = new Stack<>();
        for(int i=0; i<tokens.length; i++) {
            if (tokens[i].equals("+") || 
                tokens[i].equals("-") ||
                tokens[i].equals("/") ||
                tokens[i].equals("*")) {
                // Do Operation
                int num2 = tokenStack.pop();
                int num1 = tokenStack.pop();
                switch(tokens[i]) {
                    case "+" : tokenStack.push(num1+num2);break;
                    case "-" : tokenStack.push(num1-num2);break;
                    case "/" : tokenStack.push(num1/num2);break;
                    case "*" : tokenStack.push(num1*num2);
                }
            } else {
                tokenStack.push(Integer.valueOf(tokens[i]));
            }
        }
        return tokenStack.pop();
    }
}