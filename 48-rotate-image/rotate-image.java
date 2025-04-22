class Solution {
    public void rotate(int[][] matrix) {
        // This is a Swap Question for Spiral Matrix
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix.length-1;

        while(top <= bottom && left <= right) {

            int curr = 0;

            while (curr < bottom - top) {
                // Top Element 
                int elem1 = matrix[top][left+curr];
                int elem2 = matrix[top+curr][right];
                matrix[top+curr][right] = elem1;
                int elem3 = matrix[bottom][right-curr];
                matrix[bottom][right-curr] = elem2;
                int elem4 = matrix[bottom-curr][left]; 
                matrix[bottom-curr][left] = elem3;
                matrix[top][left+curr] = elem4;
                curr++;
            }

            top++;
            bottom--;
            left++;
            right--;
        }

    }
}