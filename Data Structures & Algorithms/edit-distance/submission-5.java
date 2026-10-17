class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++) Arrays.fill(dp[i], -1);
        return findMinOperations(0, 0, word1, word2, dp);
    }

    private int findMinOperations(int i, int j, String s1, String s2, int dp[][]){
        if(j==s2.length()) return s1.length()-i;
        if(i==s1.length()) return s2.length()-j;
        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = findMinOperations(i+1, j+1, s1, s2, dp);
        }

        return dp[i][j] = 1+Math.min(Math.min(findMinOperations(i, j+1, s1, s2, dp),
                 findMinOperations(i+1, j, s1, s2, dp)),
                 findMinOperations(i+1, j+1, s1, s2, dp));
    }
}
