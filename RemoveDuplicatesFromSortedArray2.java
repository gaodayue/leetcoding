public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] A) {
        if (A.length <= 2) return A.length;
        boolean new_word = true;
        int j = 1;
        for (int i=1; i < A.length; i++) {
            if (A[i] != A[i-1]) {
                new_word = true;
                A[j++] = A[i];
            } else if (new_word) {
                A[j++] = A[i];
                new_word = false;
            }
        }
        return j;
    }
}
