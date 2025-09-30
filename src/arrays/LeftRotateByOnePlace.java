package arrays;

public class LeftRotateByOnePlace {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rotateArrayByOne(arr);
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    public static void rotateArrayByOne(int[] arr) {
        rotate(arr,0,arr.length-1);
        rotate(arr,0,arr.length-2);
    }
    public static void rotate(int[] arr,int i,int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
