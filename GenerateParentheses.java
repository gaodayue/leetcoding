import java.util.ArrayList;

public class GenerateParentheses {
    private void recur_helper(ArrayList<String> ans, char[] buf, int depth,
                              int left_pnum, int right_pnum, int n) {
        if (right_pnum == n) {
            ans.add(new String(buf));
            return;
        }
        if (left_pnum < n) {
            buf[depth] = '(';
            recur_helper(ans, buf, depth+1, left_pnum+1, right_pnum, n);
        }
        if (left_pnum > right_pnum) {
            buf[depth] = ')';
            recur_helper(ans, buf, depth+1, left_pnum, right_pnum+1, n);
        }
    }
    
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        char[] buf = new char[2*n];
        buf[0] = '(';
        recur_helper(ans, buf, 1, 1, 0, n);
        return ans;
    }
}
