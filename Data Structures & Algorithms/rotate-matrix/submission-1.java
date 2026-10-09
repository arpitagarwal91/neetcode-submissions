class Solution {
    public void rotate(int[][] matrix) {
        int top = 0, bottom = matrix.length-1;
        while(top<=bottom){
            int l = top, r = bottom;
            for(int i=0;i<(r-l);i++){
                int tmp = matrix[top][l+i];
                matrix[top][l+i] = matrix[bottom-i][l];
                matrix[bottom-i][l] = matrix[bottom][r-i];
                matrix[bottom][r-i] = matrix[top+i][r];
                matrix[top+i][r] = tmp;
            }
            top++;
            bottom--;
        }
    }
}
