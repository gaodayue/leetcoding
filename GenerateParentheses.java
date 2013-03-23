import java.util.ArrayList;

public class GenerateParentheses {
    private void recur_helper(ArrayList<String> ans, char[] buf, int pos,
                              int lparen_num, int rparen_num, int n) {
        if (rparen_num == n) {
            ans.add(new String(buf));
            return;
        }
        if (lparen_num < n) {
            buf[pos] = '(';
            recur_helper(ans, buf, pos+1, lparen_num+1, rparen_num, n);
        }
        if (lparen_num > rparen_num) {
            buf[pos] = ')';
            recur_helper(ans, buf, pos+1, lparen_num, rparen_num+1, n);
        }
    }
    
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        char[] buf = new char[2*n];
        recur_helper(ans, buf, /*pos=*/0, /*lparen_num=*/0, /*rparen_num=*/0, n);
        return ans;
    }
}
