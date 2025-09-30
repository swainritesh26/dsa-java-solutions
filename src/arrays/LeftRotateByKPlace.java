package arrays;

public class LeftRotateByKPlace {

    // Function to rotate an array left by k places
    public static void rotateArrayByK(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle if k > n

        // Step 1: Reverse first k elements
        rotate(arr, 0, k - 1);

        // Step 2: Reverse remaining n-k elements
        rotate(arr, k, n - 1);

        // Step 3: Reverse the whole array
        rotate(arr, 0, n - 1);
    }

    //Function to rotate using Two Pointer Approach
    public static void rotate(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    //Function to test
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateArrayByK(arr, k);

        // Print result
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
