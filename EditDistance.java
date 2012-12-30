public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length()+1;
        int m = word2.length()+1;
        int[][] table = new int[n][m];
        for (int i=0; i < n; i++) {
            table[i][0] = i;
        }
        for (int j=0; j < m; j++) {
            table[0][j] = j;
        }
        for (int i=1; i < n; i++) {
            for (int j=1; j < m; j++) {
                int match = table[i-1][j-1] + 
                    ((word1.codePointAt(i-1) == word2.codePointAt(j-1)) ? 0 : 1);
                int x = 1 + table[i-1][j];  // word1[i-1] match gap
                int y = 1 + table[i][j-1];  // gap match word2[j-1]
                if (match <= x && match <= y) {
                    table[i][j] = match;
                } else if (x <= match && x <= y) {
                    table[i][j] = x;
                } else {
                    table[i][j] = y;
                }
            }
        }
        return table[n-1][m-1];
    }
}
