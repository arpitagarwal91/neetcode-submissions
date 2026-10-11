class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        return getMinEdit(0,0,word1,word2,dp);
    }

    private int getMinEdit(int i, int j, String word1, String word2, int[][] dp){
        if(j==word2.length()) return word1.length()-i;
        if(i==word1.length()) return word2.length()-j;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j] = getMinEdit(i+1, j+1, word1, word2,dp);
        }
        int insert = getMinEdit(i, j+1, word1, word2,dp);
        int replace = getMinEdit(i+1, j+1, word1, word2,dp);
        int delete = getMinEdit(i+1, j, word1, word2,dp);
        return dp[i][j] = 1+Math.min(Math.min(insert, replace), delete);
    }
}
