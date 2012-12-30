public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int end = 0;
        while (end < strs[0].length()) {
            boolean same = true;
            for (int i=0; i < strs.length-1; i++) {
                if (end >= strs[i+1].length() || strs[i].codePointAt(end) != strs[i+1].codePointAt(end)) {
                    same = false;
                    break;
                }
            }

            if (same) {
                end++;
            } else {
                break;
            }
        }
        return strs[0].substring(0, end);
    }
}
