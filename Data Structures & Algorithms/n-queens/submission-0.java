class Solution {

    Set<Integer> col = new HashSet();
    Set<Integer> posDiag = new HashSet();
    Set<Integer> negDiag = new HashSet();
    List<List<String>> res = new ArrayList();
    
    public List<List<String>> solveNQueens(int n) {
        char arr[][] = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(arr[i], '.');
        }
        backtrack(0, n, arr);
        return res;
    }

    public void backtrack(int r, int n, char arr[][]){
        if(r==n){
            List<String> ls = new ArrayList();
            for(int i=0;i<n;i++){
                StringBuilder str = new StringBuilder();
                for(int j=0;j<n;j++){
                    str.append(arr[i][j]);
                }
                ls.add(str.toString());
            }
            res.add(ls);
            return;
        }
        for(int c=0;c<n;c++){
            if(col.contains(c)||posDiag.contains(r+c)||negDiag.contains(r-c)) continue;
            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            arr[r][c] = 'Q';
            backtrack(r+1, n, arr);
            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            arr[r][c] = '.';
        }
    }
}
