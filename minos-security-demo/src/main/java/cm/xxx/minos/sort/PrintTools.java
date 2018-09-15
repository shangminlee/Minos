package cm.xxx.minos.sort;

import java.util.Random;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-21 10:24
 */
public class PrintTools {

    public static <E> void arrayPrint(E[] array,int p1,int p2) throws Exception{
        System.out.format("%8s","index:");
        for (int i = 0; i < array.length ; i++) {
            System.out.format("%5d",i);
        }
        System.out.println("");

        System.out.format("%8s","value:");
        for (int i = 0; i < array.length ; i++) {
            System.out.format("%5s", String.valueOf(array[i]));
        }

        System.out.println("");

        System.out.format("%8s","pointer:");
        for (int i = 0; i < array.length ; i++) {
            if(i == p1 || i == p2) {
                System.out.format("%5s", "↑");
            }else {
                System.out.format("%5s", "");
            }
        }
        System.out.println("\n");
    }

    public static void arrayPrint(char[] array,int p1,int p2){
        System.out.format("%8s","index:");
        for (int i = 0; i < array.length ; i++) {
            System.out.format("%5d",i);
        }
        System.out.println("");

        System.out.format("%8s","value:");
        for (int i = 0; i < array.length ; i++) {
            System.out.format("%5s", String.valueOf(array[i]));
        }

        System.out.println("");

        System.out.format("%8s","pointer:");
        for (int i = 0; i < array.length ; i++) {
            if(i == p1 || i == p2) {
                System.out.format("%5s", "↑");
            }else {
                System.out.format("%5s", "");
            }
        }
        System.out.println("\n");
    }

    public static void arrayPrint(int[] array,int p1,int p2){
        System.out.format("%8s","index:");
        for (int i = 0; i < array.length ; i++) {
            System.out.format("%5d",i);
        }
        System.out.println("");

        System.out.format("%8s","value:");
        for (int i = 0; i < array.length ; i++) {
            System.out.format("%5s", String.valueOf(array[i]));
        }

        System.out.println("");

        System.out.format("%8s","pointer:");
        for (int i = 0; i < array.length ; i++) {
            if(i == p1) {
                System.out.format("%5s", "△");
            }else if (i == p2){
                System.out.format("%5s", "▲");
            }
            else {
                System.out.format("%5s", "");
            }
        }
        System.out.println("\n");
    }


    public static void arrayPrint(int[][] array){
        for (int i = 0 , j = 0; i < array.length ; ) {
            System.out.format("%4s", String.valueOf(array[i][j++]));
            if(j >= array[i].length){
                System.out.println("");
                j = 0;
                i++;
            }
        }

    }


    public static void main(String[] args) throws Exception{
        Integer[] values = {1,2,3,4,5,6,7,8,10,11,12};
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println("");
            Thread.sleep(1000);
            arrayPrint(values,random.nextInt(values.length -1),random.nextInt(values.length - 1));
        }
    }
}
