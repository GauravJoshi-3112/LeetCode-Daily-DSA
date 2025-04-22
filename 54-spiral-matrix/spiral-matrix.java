class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Doing Matrix Multiplication
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        int row = 0;
        int col = 0;
        while(top <= bottom && left <= right) {
            row = top; // Traversing ith Row from left -> right // Fixed
            // col is dynamic 
            for(col = left; col <= right; col++) {
                list.add(matrix[row][col]);
            } 
            top++;

            // Traversing Cols from top -> bottom
            col = right;
            for(row = top; row <= bottom; row++) {
                list.add(matrix[row][col]);
            }
            right--;

            // Traversing nRows - i from right -> left
            row = bottom;
            for(col = right; top <= bottom && col >= left; col--) {
                list.add(matrix[row][col]);
            } 
            bottom--;

            // Traversing Cols from bottom -> top
            col = left;
            for(row = bottom; left <= right && row >= top; row--) {
                list.add(matrix[row][col]);
            }
            left++;
        }
        return list;
    }
}