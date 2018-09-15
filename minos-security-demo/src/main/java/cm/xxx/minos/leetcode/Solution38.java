package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution38 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length , n = matrix[0].length; // 行数 ，列数
        int[] result = new int[n * m];
        int y = 0 , x = 0; // [左，右]
        for (int i = 0; i < n + m - 1; i++) {
            //计算 深度 k
            int k = this.depth2(m,n,x,y);

            //循环 方向
            int d = (y+x)%2;

            //遍历 数组
            if(d == 0) {
                int z = y, t = x;
                for (int j = 0; j < k; j++) {
                    result[i] = matrix[z++][t--];
                }
            }else {
                int z = y + k - 1, t = x - k + 1;
                for (int j = 0; j < k; j++) {
                    result[i] = matrix[z--][t++];
                }
            }
            //前进
            if(x == n-1){
                y++;
            }
            if(x < n - 1){
                x++;
            }
        }
        return result;
    }

    //计算循环深度
    public int depth(int m , int n , int x,int y){
        if(m >= n){
            if(x < n - 1) {
                return x + 1;
            }
            int loop = m - y ;
            if(y > 0 && loop < n){
                return loop;
            }
            return n;
        }else {
            if(x < m - 1) {
                return x + 1;
            }
            int loop = m - y ;
            if(x > 0 && loop < m){
                return loop;
            }
            return m;
        }
    }

    public int depth2(int m , int n , int x,int y){
        int maxDep = Math.min(m,n);
        if(x < maxDep - 1) {
            return x + 1;
        }
        int loop = m - y ;
        if(loop < maxDep){
            return loop;
        }
        return maxDep;
    }

    /**
     *  1 , 2 , 3
     *  4 , 5 , 6
     *  7 , 8 , 9
     */
    public static void main(String[] args) {
        Solution38 solution = new Solution38();
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6}};
//        int[][] matrix = {{1,2,3,4,5,6}};
//        int[][] matrix = {{1,2,3,4,5,6}};
//        int[][] matrix = {{1,2},{3,4},{5,6},{7,8}};
//        int[][] matrix = {{1,2},{3,4}};
        int[][] matrix = new int[0][0];


        solution.findDiagonalOrder(matrix);

    }

}
