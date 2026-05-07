class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word2.length(); i++) {
            dp[word1.length()][i] = word2.length() - i;
        }   

        for (int j = 0; j < word1.length(); j++) {
            dp[j][word2.length()] = word1.length() - j;
        }

        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                }
            }
        }

        return dp[0][0];
    }
}
