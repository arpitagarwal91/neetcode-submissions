class Solution {
    public boolean isValidSudoku(char[][] board) {
       Map<Integer, Set<Character>> line = new HashMap();
       Map<Integer, Set<Character>> col = new HashMap();
       Map<String, Set<Character>> box = new HashMap();
       for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(board[i][j]!='.'){
                if((line.containsKey(i) && line.get(i).contains(board[i][j]))||(col.containsKey(j) && col.get(j).contains(board[i][j]))||(box.containsKey((i/3)+" "+(j/3)) && box.get((i/3)+" "+(j/3)).contains(board[i][j]))){
                    return false;
                }
                Set<Character> lineSet = line.getOrDefault(i, new HashSet<Character>());
                lineSet.add(board[i][j]);
                line.put(i, lineSet);
                Set<Character> colSet = col.getOrDefault(j, new HashSet<Character>());
                colSet.add(board[i][j]);
                col.put(j, colSet);
                Set<Character> boxSet = box.getOrDefault((i/3)+" "+(j/3), new HashSet<Character>());
                boxSet.add(board[i][j]);
                box.put((i/3)+" "+(j/3), boxSet);
            }
        }
       }
       return true;
    }
}
