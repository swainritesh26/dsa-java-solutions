package binarysearch;

public class KthElementFrom2Sorted {

    // 🔹 Approach 1: Brute Force (Merge Both Arrays)
    // Time: O(n1 + n2) | Space: O(n1 + n2)
    public static int kthElement1(int[] a, int[] b, int l) {
        int[] arr = new int[a.length + b.length]; // merged array
        int i = 0, j = 0, k = 0;

        // merge both sorted arrays into one
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) arr[k++] = a[i++];
            else arr[k++] = b[j++];
        }

        // add remaining elements
        while (i < a.length) arr[k++] = a[i++];
        while (j < b.length) arr[k++] = b[j++];

        // return lth (1-based) element
        return arr[l - 1];
    }

    // 🔹 Approach 2: Merge Until kth Element
    // Time: O(k) | Space: O(1)
    public static int kthElement2(int[] a, int[] b, int l) {
        int i = 0, j = 0, cnt = 0;
        int ele = -1; // stores the kth element

        // simulate merge until kth element found
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (cnt == l - 1) ele = a[i];
                cnt++;
                i++;
            } else {
                if (cnt == l - 1) ele = b[j];
                cnt++;
                j++;
            }
        }

        // handle remaining elements
        while (i < a.length) {
            if (cnt == l - 1) ele = a[i];
            cnt++;
            i++;
        }
        while (j < b.length) {
            if (cnt == l - 1) ele = b[j];
            cnt++;
            j++;
        }

        return ele;
    }

    // 🔹 Approach 3: Optimized Binary Search Partition
    // Time: O(log(min(n1, n2))) | Space: O(1)
    public static int kthElement(int[] a, int[] b, int l) {
        // always binary search on a smaller array
        if (a.length > b.length) return kthElement(b, a, l);

        int n1 = a.length, n2 = b.length;
        int left = l; // total elements on the left partition

        // binary search range
        int low = Math.max(0, l - n2);
        int high = Math.min(l, n1);

        while (low <= high) {
            int mid1 = (low + high) / 2; // elements taken from a
            int mid2 = left - mid1;      // elements taken from b

            // left and right boundaries
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            // check if partition is valid
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2); // kth element is max of left partition
            }
            // shift search space
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }

        return 0; // should never reach here
    }

    // 🔹 Main method to test all approaches
    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};

        System.out.println("Brute Force Merge: " + kthElement1(a, b, 5));
        System.out.println("Merge Until Kth: " + kthElement2(a, b, 5));
        System.out.println("Binary Search Partition: " + kthElement(a, b, 5));
    }
}
