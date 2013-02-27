import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    private ArrayList<Integer> toList(int[] t, int tsize) {
        ArrayList<Integer> list = new ArrayList<Integer>(tsize);
        for (int i=0; i < tsize; i++) {
            list.add(t[i]);
        }
        return list;
    }
    
    // each node visited in preorder-traverse is a subset
    private void preorder(int[] s, int spos, int[] t, int tpos,
                          ArrayList<ArrayList<Integer>> ans) {
        ans.add(toList(t, tpos));
        
        for (int i=spos; i < s.length; i++) {
            t[tpos] = s[i];
            preorder(s, i+1, t, tpos+1, ans);
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        int[] t = new int[S.length];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        preorder(S, 0, t, 0, ans);
        return ans;
    }
}
