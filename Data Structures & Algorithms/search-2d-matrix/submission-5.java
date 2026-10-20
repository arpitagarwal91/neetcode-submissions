class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = (m*n)-1;
        while(l<=r){
            int mid = (l+r)/2;
            int row = mid/n, col = mid%n;
            if(matrix[row][col]==target) return true;
            if(matrix[row][col]<target) l = mid+1;
            else r = mid-1;
        }
        return false;
    }
}
