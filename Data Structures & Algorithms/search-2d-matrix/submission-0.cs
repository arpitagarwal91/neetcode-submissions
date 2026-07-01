public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.Length-1;
        int mid = -1;
        while(top<=bottom){
            mid = top+(bottom-top)/2;
            if(matrix[mid][matrix[mid].Length-1]<target) top = mid+1;
            else if(matrix[mid][0]>target) bottom = mid-1;
            else break;
        }

        if(!(top<=bottom)) return false;

        int l=0;
        int r=matrix[mid].Length-1;
        while(l<=r){
            int c = l+(r-l)/2;
            if(matrix[mid][c]==target) return true;
            if(matrix[mid][c]>target) r = c-1;
            if(matrix[mid][c]<target) l = c+1;
        }
        return false;
    }
}
