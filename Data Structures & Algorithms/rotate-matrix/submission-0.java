class Solution {
    public void rotate(int[][] matrix) {
        int top = 0, bottom = matrix.length-1;
        while(top<=bottom){
            int left = top, right = bottom;
            for(int k=0;k<right-left;k++){
                int tmp = matrix[top][left+k];
                matrix[top][left+k] = matrix[bottom-k][left];
                matrix[bottom-k][left] = matrix[bottom][right-k];
                matrix[bottom][right-k] = matrix[top+k][right];
                matrix[top+k][right] = tmp;
            }
            top++;
            bottom--;
        }
    }
}
