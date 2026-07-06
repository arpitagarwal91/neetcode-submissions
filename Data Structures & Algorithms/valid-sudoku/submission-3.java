class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> box = new HashMap<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if((rows.containsKey(i) && rows.get(i).contains(board[i][j]))
                    ||(cols.containsKey(j) && cols.get(j).contains(board[i][j]))
                    ||(box.containsKey(i/3+"-"+j/3) && box.get(i/3+"-"+j/3).contains(board[i][j]))){
                        return false;
                    }
                    rows.computeIfAbsent(i, k-> new HashSet<>()).add(board[i][j]);
                    cols.computeIfAbsent(j, k-> new HashSet<>()).add(board[i][j]);
                    box.computeIfAbsent(i/3+"-"+j/3, k-> new HashSet<>()).add(board[i][j]);
                }
            }
        }
        return true;
    }
}
