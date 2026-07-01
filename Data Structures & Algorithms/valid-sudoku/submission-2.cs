public class Solution {
    public bool IsValidSudoku(char[][] board) {
        var rows = new Dictionary<int,HashSet<char>>();
        var cols = new Dictionary<int,HashSet<char>>();
        var boxes = new Dictionary<string,HashSet<char>>();
        for(int i=0;i<board.Length;i++){
            for(int j=0;j<board[0].Length;j++){
                if(board[i][j]=='.') continue;
                if((rows.ContainsKey(i) && rows[i].Contains(board[i][j]))||
                (cols.ContainsKey(j) && cols[j].Contains(board[i][j]))||
                (boxes.ContainsKey((i/3)+"-"+(j/3)) && boxes[(i/3)+"-"+(j/3)].Contains(board[i][j]))){
                    return false;
                }
                if(!rows.ContainsKey(i)) rows[i] = new HashSet<char>();
                if(!cols.ContainsKey(j)) cols[j] = new HashSet<char>();
                if(!boxes.ContainsKey((i/3)+"-"+(j/3))) boxes[(i/3)+"-"+(j/3)] = new HashSet<char>();
                rows[i].Add(board[i][j]);
                cols[j].Add(board[i][j]);
                boxes[(i/3)+"-"+(j/3)].Add(board[i][j]);
            }
        }
        return true;
    }
}
