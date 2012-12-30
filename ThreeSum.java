import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> results =
            new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len < 3)
            return results;
        Arrays.sort(num);

        for (int i=0; i<len; i++) {
            int j = i+1;
            int w = len-1;
            while (j < w) {
                if (num[j]+num[w] > -num[i]) {
                    w--;
                } else if ((num[j]+num[w] < -num[i])) {
                    j++;
                } else {
                    ArrayList<Integer> r = new ArrayList<Integer>();
                    r.add(num[i]);
                    r.add(num[j]);
                    r.add(num[w]);
                    results.add(r);
                    while (++j < w && num[j] == num[j-1]) ;
                    while (--w > j && num[w] == num[w+1]) ;
                }
            }
            while (i+1<len && num[i+1] == num[i]) {
                i++;
            }
        }

        return results;
    }
}
