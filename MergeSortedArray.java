public class MergeSortedArray {
    /**
     * A and B are sorted array, merge B into A and keep sorted.
     * Suppose A has enough room for B.
     *
     * this can be solve in O(m+n) time using Reverse Thinking
     */
    public void merge(int A[], int m, int B[], int n) {
        int last = m + n -1;
        int ai = m-1;
        int bi = n-1;
        while (ai >= 0 && bi >= 0) {
            A[last--] = (A[ai] > B[bi]) ? A[ai--] : B[bi--];
        }
        while (bi >= 0) A[last--] = B[bi--];
    }
}
