public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int dups = 0;
        int i = 0;
        while (true) {
            while (i+dups < A.length && A[i+dups] == elem) {
                dups++;
            }
            if (i+dups == A.length) break;
            A[i] = A[i+dups];
            i++;
        }
        return A.length - dups;
    }
}
