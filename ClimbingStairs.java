public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] s1 = new int[n]; // end with 1 step
        int[] s2 = new int[n]; // end with 2 steps
        s1[0] = 1;
        s2[0] = 0;
        if (n == 1) return 1;
        for (int i=1; i<n; i++) {
            s1[i] = s1[i-1] + s2[i-1];
            s2[i] = s1[i-1];
        }
        return s1[n-1] + s2[n-1];
    }
}
