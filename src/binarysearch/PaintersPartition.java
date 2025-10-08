package binarysearch;

public class PaintersPartition {

    public static int findLargestMinDistance1(int[] boards, int k) {
        int low = 0;
        int high = Integer.MIN_VALUE;

        // low = sum of all boards, high = largest single board
        for (int num : boards) {
            low += num;
            high = Math.max(high, num);
        }

        // try all possible time limits
        for (int time = high; time <= low; time++) {
            if (countPainters(boards, time) <= k) {
                return time;
            }
        }
        return low;
    }

    public static int countPainters(int[] boards, int time) {
        int painters = 1;
        long boardsPainter = 0;
        for (int board : boards) {
            if (boardsPainter + board <= time) {
                // allocate board to current painter
                boardsPainter += board;
            } else {
                // allocate board to the next painter
                painters++;
                boardsPainter = board;
            }
        }
        return painters;
    }

    public static int findLargestMinDistance(int[] boards, int k) {
        int low = Integer.MIN_VALUE, high = 0, ans = 0;

        for (int num : boards) {
            high += num;
            low = Math.max(low, num);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = countPainters(boards, mid);

            if (res <= k) {
                ans = mid;       // possible answer
                high = mid - 1;  // try to minimize
            } else {
                low = mid + 1;   // increase allowed time
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] boards = {10,20,30,40};
        int k = 2;
        int ans = findLargestMinDistance(boards, k);
        System.out.println(ans);
    }
}
