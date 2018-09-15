package cm.xxx.minos.leetcode;


import cm.xxx.minos.sort.PrintTools;

/**
 * 542. 01 矩阵 未完成！！！！！！！！！！！！！！
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 *
 * 1 1 1
 * 1 1 0
 * 1 0 1
 */
public class Solution83 {

    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int k = 1;
        for (int i = 0, j = 0; i < matrix.length;) {
//            PrintTools.arrayPrint(matrix);
//            System.out.println();
//            PrintTools.arrayPrint(result);
//            System.out.println("---------------------");


            if(matrix[i][j] == k){
                System.out.println("-----------------------------");
                result[i][j] = this.dfs(matrix,i,j,++k);
            }else{
                result[i][j] = 0;
            }
            j++;
            if(j >= matrix[i].length){
                j = 0;
                i++;
            }
        }
        return result;
    }

    private int dfs(int[][] search,int sr ,int sc,int k){
        System.out.println("sr :" + sr + " sc :" + sc);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int old = search[sr][sc];
        if(old == 0) {
            return 0;
        }
        if(old == k){
            return -1;
        }
        search[sr][sc] = k;
        int step = 0;

        //向上
        if(sr - 1 >= 0 && search[sr - 1][sc] == old){
            int count = dfs(search,sr - 1, sc,k);
            step = min(step,count);
        }
        //向后
        if(sc - 1 >= 0 && search[sr][sc - 1] == old){
            int count = dfs(search,sr, sc - 1,k);
            step = min(step,count);
        }
        //向下
        if(sr + 1 < search.length && search[sr + 1][sc] == old){
            int count = dfs(search,sr + 1, sc,k);
            step = min(step,count);
        }
        //向前
        if(sc + 1 < search[sr].length && search[sr][sc + 1] == old){
            int count = dfs(search,sr, sc + 1,k);
            step = min(step,count);
        }
        return step;
    }

    private int min(int step, int count){
        if(count == -1 || step == 0 || step == -1) {
            step = count;
        }else{
            step = Math.max(step,count) + 1;
        }
        return step;
    }


    public static void main(String[] args) {
        Solution83 solution = new Solution83();
        int[][] matrix = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] r = solution.updateMatrix(matrix);
        PrintTools.arrayPrint(r);
    }

}
