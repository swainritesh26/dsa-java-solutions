package arrays;

public class SingleNumber {

    // Finds the single number in an array where every other number appears twice
    public static int singleNumber(int[] arr) {
        int res = 0;
        for (int num : arr) {
            res ^= num; // XOR accumulates to find the unique number
        }
        return res; // return the single number
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 3, 1, 4};
        System.out.println(singleNumber(arr)); // print the single number
    }
}
