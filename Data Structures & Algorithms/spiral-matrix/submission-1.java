class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length-1;
        int l = 0, r = matrix[0].length-1;
        while(top<=bottom && l<=r){
            for(int i=l;i<=r;i++) res.add(matrix[top][i]);
            top++;
            for(int i=top;i<=bottom;i++) res.add(matrix[i][r]);
            r--;
            if(top>bottom || l>r) break;
            for(int i=r;i>=l;i--) res.add(matrix[bottom][i]);
            bottom--;
            for(int i=bottom;i>=top;i--) res.add(matrix[i][l]);
            l++;
        }
        return res;
    }
}
