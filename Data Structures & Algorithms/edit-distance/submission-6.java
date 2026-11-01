class Solution {
    public int minDistance(String word1, String word2) {
        Integer dp[][] = new Integer[word1.length()][word2.length()];
        return getEditDistance(0, 0, word1, word2, dp);
    }

    private int getEditDistance(int i, int j, String s1, String s2, Integer dp[][]){
        if(i==s1.length() && j==s2.length()) return 0;
        if(i==s1.length()) return s2.length()-j;
        if(j==s2.length()) return s1.length()-i;
        if(dp[i][j]!=null) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = getEditDistance(i+1, j+1, s1, s2, dp);
        int insert = getEditDistance(i+1, j, s1, s2, dp);
        int delete = getEditDistance(i, j+1, s1, s2, dp);
        int replace = getEditDistance(i+1, j+1, s1, s2, dp);
        return dp[i][j] = 1+Math.min(Math.min(insert, delete),Math.min(delete,replace));
    }
}
