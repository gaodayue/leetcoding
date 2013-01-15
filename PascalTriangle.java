import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> prerow = null;
        for (int i = 1; i <= numRows; i++) {
            if (prerow == null) {
                prerow = new ArrayList<Integer>();
                prerow.add(1);
                triangle.add(prerow);
            } else {
                ArrayList<Integer> row = new ArrayList<Integer>();
                row.add(1);
                for (int j=1; j < i-1; j++) {
                    row.add(prerow.get(j-1) + prerow.get(j));
                }
                row.add(1);
                triangle.add(row);
                prerow = row;
            }
        }
        return triangle;
    }
}
