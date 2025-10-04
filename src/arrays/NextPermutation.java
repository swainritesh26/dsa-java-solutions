package arrays;

public class NextPermutation {

    //For Brute Force Solution Generate All combinations and return the next combination of input.
    //If input is at last combination, return the first combination as answer

    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int inx = -1;

        // Step 1: Find the first index from right where arr[i] < arr[i+1]
        // This is the point where the descending order breaks
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                inx = i;
                break;
            }
        }

        // If no such index found, array is in descending order
        // So reverse the array to get the smallest permutation
        if (inx == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Step 2: Find the smallest element on right side of 'inx' that is greater than arr[inx]
        for (int i = n - 1; i >= inx; i--) {
            if (arr[i] > arr[inx]) {
                // Swap arr[i] and arr[inx]
                int temp = arr[i];
                arr[i] = arr[inx];
                arr[inx] = temp;
                break;
            }
        }

        // Step 3: Reverse the part after index 'inx' to make it smallest possible
        reverse(arr, inx + 1, n - 1);
    }

    // Helper function to reverse array between two indexes
    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        nextPermutation(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
