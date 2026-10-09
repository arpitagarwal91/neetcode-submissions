class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length-1;
        int mid = -1;
        while(top<=bottom){
            mid = (top+bottom)/2;
            if(matrix[mid][matrix[0].length-1]<target) top = mid+1;
            else if(matrix[mid][0]>target) bottom = mid-1;
            else break;
        }
        if(top>bottom) return false;
        int l = 0, r = matrix[0].length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(matrix[mid][m]==target) return true;
            if(matrix[mid][m]<target) l = m+1;
            else r = m-1;
        }
        return false;
    }
}
