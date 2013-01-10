import java.util.ArrayList;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (k == 1) {
            for (int i=1; i <= n; i++) {
                ArrayList<Integer> comb = new ArrayList<Integer>();
                comb.add(i);
                result.add(comb);
            }
            return result;
        }
        for (int i=n; i>=k; i--) {
            // combination ended with i
            for (ArrayList<Integer> comb : combine(i-1, k-1)) {
                comb.add(i);
                result.add(comb);
            }
        }
        return result;
    }
}
