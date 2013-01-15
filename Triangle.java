import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int rownum = triangle.size();
        // cur_row[i] = min path sum ended in ith index of the current row
        int[] cur_row = new int[rownum];
        int[] pre_row = new int[rownum];
        cur_row[0] = pre_row[0] = triangle.get(0).get(0);
        for (int i=1; i < rownum; i++) {
            for (int j=0; j <= i; j++) {
                int upperleft  = (j == 0) ? pre_row[j] : pre_row[j-1];
                int upperright = (j == i) ? pre_row[j-1] : pre_row[j];
                cur_row[j] = triangle.get(i).get(j) + Math.min(upperleft, upperright);
            }
            
            System.arraycopy(cur_row, 0, pre_row, 0, i+1);
        }
        int result = Integer.MAX_VALUE;
        for (int i=0; i < rownum; i++) {
            if (result > cur_row[i]) {
                result = cur_row[i];
            }
        }
        return result;
    }
}
