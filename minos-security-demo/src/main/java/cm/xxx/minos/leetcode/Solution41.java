package cm.xxx.minos.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution41 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return result;

        int m = matrix.length , n = matrix[0].length;
        int y = 0 , x = 0;
        while (m > 0 && n > 0) {
            int c = 2 * (m - 1) + 2 * (n - 1);
            if(m == 1 || n == 1) {
                c = c / 2 + 1;
            }
            int z = y , t = x;
            boolean sw = true;
            while (c > 0){
                System.out.print("["+z+","+t+"] ");
                result.add(matrix[z][t]);
                if(t == n + x - 1 && z == m + y -1) sw = false;
                if(sw) {
                    if (t == n + x - 1) {
                        z++;
                    }
                    if (t < n + x - 1) {
                        t++;
                    }
                }else {
                    if(t == x){
                        z--;
                    }
                    if(z == m + y - 1){
                        t--;
                    }
                }
                c--;
            }
            m -= 2;
            n-= 2;
            y++;
            x++;
            System.out.println();
        }
        return result;
    }


    public static void main(String[] args) {
        Solution41 solution = new Solution41();
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6}};
//        int[][] matrix = {{1,2,3,4,5,6}};
//        int[][] matrix = {{1,2,3,4,5,6},{1,2,3,4,5,6}};
//        int[][] matrix = {{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6}};
//        int[][] matrix = {{1}};
//        int[][] matrix = {{1,2},{3,4},{5,6},{7,8}};
//        int[][] matrix = {{1,2},{3,4}};
//        int[][] matrix = {{1,2,3},{3,4,3}};
//        int[][] matrix = {{1,2,3},{3,4,3},{3,4,3}};
        int[][] matrix = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
//        int[][] matrix = new int[0][0];


        solution.spiralOrder(matrix);

    }

}
