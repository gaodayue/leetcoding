import java.util.ArrayList;

public class PalindromePartition {
    ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
    
    /**
     * DFS approach from http://blog.sina.com.cn/s/blog_b9285de20101jbtl.html
     *
     * one improving notes: notice that most of the time is wasted in palindrome
     * check, therefore we can do all the checks using DP in O(n^2) time at the
     * beginning and store the results in a 2D boolean array.
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        all.clear();
        DFS(new ArrayList<String>(), s, 0);
        return all;
    }
    
    private boolean isPal(String s, int first, int last) {
        while (first < last) {
            if (s.charAt(first) != s.charAt(last)) return false;
            first++;
            last--;
        }
        return true;
    }
    
    private void DFS(ArrayList<String> acc, String s, int start) {
        if (start == s.length()) {
            all.add(new ArrayList<String>(acc));
            return;
        }
        for (int end=start+1; end <= s.length(); end++) {
            if (isPal(s, start, end-1)) {
                acc.add(s.substring(start, end));
                DFS(acc, s, end);
                acc.remove(acc.size()-1);
            }
        }
    }
}
