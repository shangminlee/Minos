package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution37 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int n = matrix.length , m = matrix[0].length;
        int[] array = new int[n * m];
        int y = 0, z = Math.min(m,n), x = 0;
        for (int i = 0; i < m; i++) {
            int p1 = 0, p2 = i;
            for (int k = 0; k <= y; k++) {
                int v = i%2 == 0 ? matrix[p1++][p2--]:matrix[p2--][p1++];
                array[x++] = v;
                System.out.println(" "+ v);
            }
            if(y < z) y++;
        }
        y = z - 1;
        for (int i = n - 1, j = 1; i >= 0; i--,j++) {
            int p1 = j, p2 = m-1;
            for (int k = 0; k < y; k++) {
                int v = i%2 == 1 ? matrix[p1++][p2--]:matrix[p2--][p1++];
                array[x++] = v;
                System.out.println(" "+ v);
            }
            if(y > 0) y--;
        }
        return array;
    }

    /**
     *  1 , 2 , 3
     *  4 , 5 , 6
     *  7 , 8 , 9
     */
    public static void main(String[] args) {
        Solution37 solution = new Solution37();
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = {{1,2,3,4},{1,2,3,4}};
//        int[][] matrix = {{1,2},{3,4},{5,6},{7,8}};
        //solution.findDiagonalOrder(matrix);
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //顺序遍历
        //int max = matrix.length * matrix[0].length;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.printf("i:%d j:%d value:%d %n",i,j,matrix[i][j]);
//            }
//        }
//        System.out.println();
//
//        int j = 0;
//        for (int i = 0; i < matrix.length; ) {
//            System.out.printf("i:%d j:%d value:%d %n",i,j,matrix[i][j]);
//            if(j++ >= matrix[i].length - 1) {
//                i++;
//                j=0;
//            }
//        }

        // n * n 对角线遍历
//        int n = matrix.length , m = matrix[0].length;
//        for (int i = 0; i < m; i++) {
//            int p1 = i/m, p2 = i%m;
//            for (int k = 0; k <= i; k++) {
////                System.out.printf("%d , %d : %n",p1++,p2--);
//                System.out.printf("%d , %d : %d %n",p1,p2,matrix[p1++][p2--]);
//            }
//            System.out.println();
//        }
//        for (int i = n - 1, j = 1; i >= 0; i--,j++) {
//            int p1 = j, p2 = n-1;
//            for (int k = 0; k < i; k++) {
////                System.out.printf("%d , %d : %n",p1++,p2--);
//                System.out.printf("%d , %d : %d %n",p1,p2,matrix[p1++][p2--]);
//            }
//            System.out.println();
//        }

        //奇偶方向
//        int n = matrix.length , m = matrix[0].length;
//        int y = 0, z = Math.min(m,n);
//        for (int i = 0; i < m; i++) {
//            int p1 = 0, p2 = i;
//            for (int k = 0; k <= y; k++) {
//                int x = i%2 == 0 ? matrix[p1++][p2--]:matrix[p2--][p1++];
//                System.out.println(x);
//            }
//            if(y < z) y++;
//            System.out.println();
//        }
//        System.out.println();
//        y = z - 1;
//        for (int i = n - 1, j = 1; i >= 0; i--,j++) {
//            int p1 = j, p2 = n-1;
//            for (int k = 0; k < y; k++) {
//                int x = i%2 == 1 ? matrix[p1++][p2--]:matrix[p2--][p1++];
//                System.out.println(x);
//            }
//            if(y > 0) y--;
//            System.out.println();
//        }

        int m = matrix.length , n = matrix[0].length; // 行数 ，列数
        int[] result = new int[n * m];
        int r = 0 , c = 0; // [左，右]
        for (int i = 0; i < result.length; i++) {
            //System.out.println(matrix[r][c]);
            //result[i] = matrix[r][c];
            System.out.printf("%d , %d : %n",r,c);
            if(c == n - 1){
                r++;
            }else if(r == 0){
                c++;
            }else {
                r--;
                c++;
            }
        }

    }

}
