package binarysearch;

public class SplitSubArrayLargestSum {

    public static int splitArray(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : arr){
            sum += num;
            max = Math.max(max,num);
        }
        for(int i=max;i<=sum;i++){
            if(countSubArray(arr,i) == k){
                return i;
            }
        }
        return -1;
    }

    public static int countSubArray(int[] arr,int sum){
        int subArray = 1;
        int sumArray = 0;
        for(int num : arr){
            if(sumArray + num <= sum){
                sumArray += num;
            }
            else{
                subArray++;
                sumArray = num;
            }
        }
        return subArray;
    }

    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(arr,k));
    }
}
