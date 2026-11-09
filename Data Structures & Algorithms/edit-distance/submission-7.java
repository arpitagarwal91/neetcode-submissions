class Solution {
    public int minDistance(String word1, String word2) {
        Integer dp[][] = new Integer[word1.length()][word2.length()];
        return getEditDistance(0, 0, word1, word2, dp);
    }

    private int getEditDistance(int i, int j, String word1, String word2, Integer dp[][]){
        if(j==word2.length()) return word1.length()-i;
        if(i==word1.length()) return word2.length()-j;
        if(dp[i][j]!=null) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)) return dp[i][j] = getEditDistance(i+1, j+1, word1, word2, dp);
        int replace = getEditDistance(i+1, j+1, word1, word2, dp);
        int delete = getEditDistance(i+1, j, word1, word2, dp);
        int insert = getEditDistance(i, j+1, word1, word2, dp);
        return dp[i][j] = 1 + Math.min(Math.min(replace, delete), Math.min(delete, insert));
    }
}
