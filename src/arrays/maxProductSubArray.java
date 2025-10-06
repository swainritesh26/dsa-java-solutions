package arrays;

public class maxProductSubArray {

    // Brute Force Approach - O(n^2)
    public static int maxProduct1(int[] arr) {
        int n = arr.length;
        int product = 0;
        if(n == 1) return arr[0]; // if only one element, return it
        for(int i=0;i<n;i++){
            int sum = 1;
            for(int j=i;j<n;j++){
                sum *= arr[j]; // multiply elements in subarray
                product = Math.max(sum,product); // update max product
            }
        }
        return product;
    }

    // Optimized Approach - O(n)
    public static int maxProduct(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0]; // single element case

        int maxi = 0;       // store maximum product found
        int prefix = 1;     // product from start
        int suffix = 1;     // product from the end

        for(int i=0;i<n;i++){
            // if the product becomes 0, reset to 1 (to start new subarray)
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            // multiply prefix from left and suffix from right
            prefix = prefix * arr[i];
            suffix = suffix * arr[n - i - 1];

            // take the maximum of all possible values
            maxi = Math.max(maxi, Math.max(prefix, suffix));
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(maxProduct(arr)); // Output: 6
    }
}
