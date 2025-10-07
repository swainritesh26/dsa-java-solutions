package binarysearch;

public class BookAllocation {

    // 🔹 Brute Force Approach (O(sum - max))
    public static int findPages1(int[] arr, int m) {
        // if books less than students → not possible
        if (arr.length < m) return -1;

        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : arr) {
            sum += num;                 // total pages
            max = Math.max(num, max);   // maximum pages in one book
        }

        // try all possible maximum pages from max → sum
        for (int page = max; page <= sum; page++) {
            int cntStd = countStudent(arr, page);
            if (cntStd == m) return page; // if exactly m students required
        }
        return -1;
    }

    // helper function → returns how many students are needed
    // if each student can read at most 'pages' pages
    public static int countStudent(int[] arr, int pages) {
        int std = 1;          // number of students
        int pagesStudent = 0; // current student's page count

        for (int num : arr) {
            if (pagesStudent + num <= pages) {
                // assign a book to the same student
                pagesStudent += num;
            } else {
                // move to the next student
                std++;
                pagesStudent = num;
            }
        }
        return std;
    }

    // 🔹 Optimized Binary Search Approach
    public static int findPages(int[] arr, int m) {
        if (arr.length < m) return -1;

        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : arr) {
            sum += num;
            max = Math.max(num, max);
        }

        int low = max, high = sum, ans = -1;

        // binary search on answer (minimum maximum pages)
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = countStudent(arr, mid);

            if (res > m) {
                // more students needed → pages per student too low
                low = mid + 1;
            } else {
                // possible solution → try to minimize pages further
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int m = 2;
        System.out.println(findPages(arr, m));
    }
}
