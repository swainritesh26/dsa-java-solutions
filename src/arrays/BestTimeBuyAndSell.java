package arrays;

public class BestTimeBuyAndSell {

    // Brute force O(n^2)
    public static int maxProfit1(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j] - arr[i]);
            }
        }
        return max;
    }

    // Optimized O(n) solution
    public static int maxProfit(int[] arr) {
        int minPrice = Integer.MAX_VALUE; // track minimum so far
        int maxProfit = 0;

        for (int price : arr) {
            minPrice = Math.min(minPrice, price);        // buy at min
            maxProfit = Math.max(maxProfit, price - minPrice); // sell at current - min
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 8, 11, 9};
        System.out.println(maxProfit(arr));
    }
}
