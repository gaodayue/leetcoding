public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length <= 1) return A.length;
        int j = 1;
        for (int i=1; i < A.length; i++) {
            if (A[i] != A[i-1]) {
                A[j++] = A[i];
            }
        }
        return j;
    }
}
