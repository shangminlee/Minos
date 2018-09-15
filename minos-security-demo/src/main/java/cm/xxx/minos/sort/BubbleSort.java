package cm.xxx.minos.sort;

import java.util.Random;

/**
 * Description: 冒泡排序
 * Author: lishangmin
 * Created: 2018-08-21 10:24
 */
public class BubbleSort {

    public static void sort(Integer[] values) throws Exception{
        int sleepTime = 500;

        for (int i = 0; i < values.length - 1; i++) {
            Thread.sleep(sleepTime);
            int pointer = 0;
            PrintTools.arrayPrint(values,pointer,pointer);
            for (int j = 0; j < values.length - (i+1); j++) {
                Thread.sleep(sleepTime);
                if(values[j] > values[j + 1]){
                    values[j+1] = values[j+1] + values[j];
                    values[j] = values[j+1] - values[j];
                    values[j+1] = values[j+1] - values[j];
                }
                pointer = j + 1;
                PrintTools.arrayPrint(values,pointer,pointer);
            }
        }
    }


    public static void main(String[] args) throws Exception{
        Integer[] values = new Integer[4];
        Random random = new Random();
        for (int i = 0; i < values.length ; i++) {
            values[i] = random.nextInt(100);
        }
        sort(values);
    }
}
