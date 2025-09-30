package arrays;

public class SecondLargestElementWithoutSorting {
    public static void main(String[] args) {
        int[] arr = {8, 8, 8, 8, 8};
        System.out.println(secondLargestElement(arr));
    }

    public static int secondLargestElement(int[] arr) {
        int secondMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }
        if (secondMax == Integer.MIN_VALUE) {
            return -1;
        }
        return secondMax;
    }
}