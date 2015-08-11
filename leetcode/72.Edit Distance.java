public class Solution {
    public static int minDistance(String word1, int i, int len1, String word2, int j, int len2, int[][] hist) {
        if(i == 0) return j;
        if(j == 0) return i;
        if(hist[i][j] != -1) return hist[i][j];
        int i2j_1 = minDistance(word1, i, len1, word2, j - 1, len2, hist) + 1;
        int i_12j = minDistance(word1, i - 1, len1, word2, j, len2, hist) + 1;
        int i_12j_1 = minDistance(word1, i - 1, len1, word2, j - 1, len2, hist) + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
        if(i2j_1 > i_12j) i2j_1 = i_12j;
        if(i2j_1 > i_12j_1) i2j_1 = i_12j_1;
        hist[i][j] = i2j_1;
        return i2j_1;
    }
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] hist = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++)
        	for(int j = 0; j <= len2; j++)
        		hist[i][j] = -1;
        return minDistance(word1, len1, len1, word2, len2, len2, hist);
    }
}