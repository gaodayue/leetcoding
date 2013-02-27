import java.util.HashMap;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if(num.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        for (int n : num) {
            if (map.containsKey(n)) continue;  // ignore duplicates
            map.put(n, 1);
            if (map.containsKey(n-1))
                max = Math.max(max, union(map, n-1, n));
            if (map.containsKey(n+1))
                max = Math.max(max, union(map, n, n+1));
        }
        return max;
    }
    
    private int union(HashMap<Integer, Integer> map, int left, int right) {
        int low  = left - map.get(left) + 1;
        int high = right + map.get(right) - 1;
        int len = high - low + 1;
        map.put(low, len);
        map.put(high, len);
        return len;
    }
}
