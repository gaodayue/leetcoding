public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] table = new int[s.length()+1];
        table[0] = 1;
        
        for (int i=1; i < table.length; i++) {
            char c = s.charAt(i-1);
            if (c >= '1' && c <= '9') {
                table[i] = table[i-1];
            }
            if (i > 1) {
                char pc = s.charAt(i-2);
                if (   (pc == '1' && (c >= '0' && c <= '9'))
                    || (pc == '2' && (c >= '0' && c <= '6')) ) {
                
                    table[i] += table[i-2];
                }
            }
        }
        
        return table[table.length-1];
    }
}
