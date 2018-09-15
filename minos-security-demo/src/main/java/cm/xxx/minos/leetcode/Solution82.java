package cm.xxx.minos.leetcode;


import cm.xxx.minos.sort.PrintTools;

/**
 * 733. 图像渲染
 * 测试用例：
 *  回到原点，中断递归
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution82 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor == newColor){
            return image;
        }
        image[sr][sc] = newColor;
        PrintTools.arrayPrint(image);
        try{
            Thread.sleep(2000);
            System.out.println();
        }catch (Exception ignored) {

        }
        if(sr - 1 >= 0 && image[sr - 1][sc] == oldColor){
            image = floodFill(image,sr - 1, sc,newColor);
        }
        if(sc - 1 >= 0 && image[sr][sc - 1] == oldColor){
            image = floodFill(image,sr, sc - 1,newColor);
        }
        if(sr + 1 < image.length && image[sr + 1][sc] == oldColor){
            image = floodFill(image,sr + 1, sc,newColor);
        }
        if(sc + 1 < image[sr].length && image[sr][sc + 1] == oldColor){
            image = floodFill(image,sr, sc + 1,newColor);
        }
        return image;
    }



    public static void main(String[] args) {
        Solution82 solution = new Solution82();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        solution.floodFill(image,1,1,2);

    }

}
