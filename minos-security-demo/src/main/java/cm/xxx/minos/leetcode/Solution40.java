package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution40 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n == 0) return matrix;
        int value = 1;
        int m = matrix.length , w = matrix[0].length;
        int y = 0 , x = 0;
        while (m > 0 && w > 0) {
            int c = 2 * (m - 1) + 2 * (w - 1);
            if(m == 1 || w == 1) {
                c = c / 2 + 1;
            }
            int z = y , t = x;
            boolean sw = true;
            while (c > 0){
                matrix[z][t] = value++;
                if(t == w + x - 1 && z == m + y -1) sw = false;
                if(sw) {
                    if (t == w + x - 1) {
                        z++;
                    }
                    if (t < w + x - 1) {
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
            w -= 2;
            y++;
            x++;
        }
        return matrix;
    }


    public static void main(String[] args) {
        Solution40 solution = new Solution40();
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


    }

}
