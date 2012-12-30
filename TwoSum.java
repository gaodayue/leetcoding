public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        for (int i=0; i < numbers.length-1; i++) {
            int j = i+1;
            while (numbers[i]+numbers[j] != target && j+1 < numbers.length) {
                j++;
            }
            if (numbers[i]+numbers[j] == target) {
                return new int[] {i+1, j+1};
            }
        }
        return null;
    }
}
