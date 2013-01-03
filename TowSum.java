public class TowSum {
    /* You may assume each input would have exactly one solution*/
    public int[] twoSum(int[] numbers, int target) {
        for (int i=0; i < numbers.length-1; i++) {
            for (int j=i+1; j < numbers.length; j++) {
                if (numbers[i]+numbers[j] == target) {
                    int[] result = {i+1, j+1};
                    return result;
                }
            }
        }
        throw new RuntimeException("no solution");
    }
}
