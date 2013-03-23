public class PalindromePartition2 {
    /* this can be solve using dynamic programming */
    public int minCut(String s) {
        // isPal[i][j] is true if substring s[i:j] is a palindrome
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for (int k=0; k < s.length(); k++) {
            for (int i=0; i+k < s.length(); i++) {
                isPal[i][i+k] = (s.charAt(i) == s.charAt(i+k)) && (k < 2 || isPal[i+1][i+k-1]);
            }
        }
        // table[i] is the minimal cut of substring s[0:i]
        int[] table = new int[s.length()];
        table[0] = 0;
        for (int i=1; i < s.length(); i++) {
            table[i] = 1 + table[i-1];
            for (int start=0; start < i; start++) {
                if (isPal[start][i]) { //s[start:i] may be the last cut
                    table[i] = Math.min(table[i], start==0 ? 0 : 1 + table[start-1]);
                }
            }
        }
        return table[s.length()-1];
    }
}
