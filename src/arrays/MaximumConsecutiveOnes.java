package arrays;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] arr) {
        int count = 0, maxCount = 0;
        for (int num : arr) {
            if (num == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}
