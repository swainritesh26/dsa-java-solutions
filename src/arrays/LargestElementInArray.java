package arrays;

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {99,100,-1,5,2};
        System.out.println(largestElement(arr));
    }
    public static int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            if(i>max){
                max = i;
            }
        }
        return max;
    }
}
