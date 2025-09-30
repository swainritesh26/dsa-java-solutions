package arrays;

public class MoveZeroToEnd {

    //Function to move zeroes to end
    public static void moveZeroes(int[] arr) {
        int n = arr.length, k = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[k] = arr[i];
                k++;
            }
        }
        while (k < n) {
            arr[k] = 0;
            k++;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
