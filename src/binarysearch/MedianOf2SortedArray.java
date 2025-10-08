package binarysearch;

public class MedianOf2SortedArray {

    // 🔹 Approach 1: Brute Force - Merge Both Arrays (O(n1 + n2), O(n1 + n2))
    public static double findMedianSortedArrays1(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length]; // merged array
        int n = arr3.length;
        int i = 0, j = 0, k = 0;

        // merge two sorted arrays into arr3
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) arr3[k++] = arr2[j++];
            else arr3[k++] = arr1[i++];
        }

        // copy remaining elements
        while (i < arr1.length) arr3[k++] = arr1[i++];
        while (j < arr2.length) arr3[k++] = arr2[j++];

        // compute median
        if (n % 2 == 0)
            return (arr3[n / 2] + arr3[(n / 2) - 1]) / 2.0;
        else
            return arr3[n / 2];
    }

    // 🔹 Approach 2: Merge Until Median (O(n1 + n2), O(1))
    public static double findMedianSortedArrays2(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int n = n1 + n2;

        int i = 0, j = 0, cnt = 0;
        int idx1 = (n - 1) / 2;  // left middle index
        int idx2 = n / 2;        // right middle index
        int in1ele = -1, in2ele = -1;

        // simulate merging until median indices
        while (i < n1 && j < n2) {
            int val = (arr1[i] <= arr2[j]) ? arr1[i++] : arr2[j++];
            if (cnt == idx1) in1ele = val;
            if (cnt == idx2) in2ele = val;
            cnt++;
        }

        // remaining elements in arr1
        while (i < n1) {
            int val = arr1[i++];
            if (cnt == idx1) in1ele = val;
            if (cnt == idx2) in2ele = val;
            cnt++;
        }

        // remaining elements in arr2
        while (j < n2) {
            int val = arr2[j++];
            if (cnt == idx1) in1ele = val;
            if (cnt == idx2) in2ele = val;
            cnt++;
        }

        // compute median
        if (n % 2 == 1) return in2ele;
        return (in1ele + in2ele) / 2.0;
    }

    // 🔹 Approach 3: Optimized Binary Search Partition (O(log min(n1,n2)), O(1))
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        if (n1 > n2) return findMedianSortedArrays(arr2, arr1); // binary search on a smaller array

        int n = n1 + n2;
        int left = (n + 1) / 2; // elements in the left half
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) / 2;      // partition in arr1
            int mid2 = left - mid1;           // partition in arr2

            // boundary values
            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            // perfect partition condition
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2); // odd length
                else return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0; // even length
            }
            else if (l1 > r2) high = mid1 - 1; // move a partition left
            else low = mid1 + 1;               // move partition right
        }

        return 0.0;
    }

    // 🔹 Main method to test all approaches
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};

        System.out.println("Median using brute force merge: " + findMedianSortedArrays1(arr1, arr2));
        System.out.println("Median using merge until median: " + findMedianSortedArrays2(arr1, arr2));
        System.out.println("Median using binary search partition: " + findMedianSortedArrays(arr1, arr2));
    }
}
