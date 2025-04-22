class Solution {
    List<String> validParenthesis = new ArrayList<>();

    public void generateParenthesisHelp(String str, int open, int closed, int n) {
        if (str.length() == 2*n && open == closed) {
            validParenthesis.add(str);
            return;
        } else if (str.length() == 2*n || open > n || closed > open) return;
        else {
            generateParenthesisHelp(str+"(",open+1,closed,n);
            generateParenthesisHelp(str+")",open,closed+1,n);  
        } 
    }
    public List<String> generateParenthesis(int n) {
        generateParenthesisHelp("",0,0,n);
        return validParenthesis;
    }
}