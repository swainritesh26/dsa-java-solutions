package arrays;

public class RemoveDuplicateFromSortedArray {

    // Removes duplicates from a sorted array
    // Returns new length of an array
    public static int removeDuplicates(int[] arr) {
        int n = arr.length;
        int k = 1;            // index for unique elements

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {  // if current is different
                arr[k] = arr[i];     // place at k
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(removeDuplicates(arr));
    }
}
