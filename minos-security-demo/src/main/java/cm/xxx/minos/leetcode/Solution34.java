package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution34 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;

            }
        }
    }

    public void rotate2(int[][] matrix) {
        for (int i = 0; i < matrix.length ; i++) {
            for(int j=i;j<matrix[i].length;j++){
                int k=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=k;
            }
            print(matrix);
        }
    }

    public static void main(String[] args) {
        Solution34 solution = new Solution34();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //print(matrix);
        print(matrix2);
        solution.rotate(matrix2);
        //print(matrix);

//        System.out.println(Arrays.toString(matrix));
    }

    private static void print(int[][] matrix){
        for (int i = 0, j = 0; i < matrix.length ; ) {
            System.out.printf("%3d ",matrix[i][j++]);
            if(j >= matrix[i].length){
                j=0;
                i++;
                System.out.println();
            }
        }
        System.out.println();
    }




}
