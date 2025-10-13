package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class UnionOf2SortedArray {

    public static int[] unionArray1(int[] arr1, int[] arr2) {
        Set<Integer> st = new HashSet<>();
        for(int num1 : arr1){
            st.add(num1);
        }
        for(int num2 : arr2){
            st.add(num2);
        }
        int[] arr = new int[st.size()];
        int i=0;
        for(int num : st){
            arr[i] = num;
            i++;
        }
        return arr;
    }

    public static int[] unionArray(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i])
                    result.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != arr2[j])
                    result.add(arr2[j]);
                j++;
            } else { // both equal
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i])
                    result.add(arr1[i]);
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr1[i])
                result.add(arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr2[j])
                result.add(arr2[j]);
            j++;
        }

        // Convert to array
        int[] union = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            union[k] = result.get(k);
        }

        return union;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,7};
        System.out.println(Arrays.toString(unionArray(arr1,arr2)));
    }
}
