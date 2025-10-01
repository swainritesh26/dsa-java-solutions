package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixPrint {

    // Function to return elements in spiral order
    public static List<Integer> spiralOrder(int[][] arr) {
        List<Integer> ls = new ArrayList<>();
        int fr = 0;                 //first row
        int lr = arr.length-1;      //last row
        int fc = 0;                 //first column
        int lc = arr[0].length-1;   //last column
        while(fr <= lr && fc <= lc){
            // Traverse top row
            for(int i=fc;i<=lc;i++){
                ls.add(arr[fr][i]);
            }
            fr++;
            if(fr > lr) break;          //check boundary
            // Traverse right column
            for(int i=fr;i<=lr;i++){
                ls.add(arr[i][lc]);
            }
            lc--;
            if(fc > lc) break;          //check boundary
            // Traverse bottom row
            for(int i=lc;i>=fc;i--){
                ls.add(arr[lr][i]);
            }
            lr--;
            // Traverse left column
            for(int i=lr;i>=fr;i--){
                ls.add(arr[i][fc]);
            }
            fc++;
        }
        return ls;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {7, 8, 9, 1},
                {5, 9, 2, 3}
        };
        List<Integer> ls = spiralOrder(arr);
        System.out.println(ls);
    }
}
