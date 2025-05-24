class Solution {
    public int getRow(int [][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i1 = 0, i2 = m - 1;
        int j1 = 0, j2 = n - 1;

        while (i1 <= i2) {
            int mid = (i1+i2)/2;
            if (matrix[mid][0] <= target && matrix[mid][n-1] >= target) return mid;
            else if (matrix[mid][0] > target) {
                i2 = mid-1;
            } else {
                i1 = mid+1;
            }
        }

        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i1 = 0, i2 = m - 1;
        int j1 = 0, j2 = n - 1;
        int row = getRow(matrix, target);
        if (row == -1) return false;
        
        while (j1 <= j2) {
            int mid = (j1+j2)/2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) j2 = mid-1;
            else j1 = mid+1;
        }

        return false;

    }
}