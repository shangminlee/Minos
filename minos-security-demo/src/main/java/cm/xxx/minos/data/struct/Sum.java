package cm.xxx.minos.data.struct;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-12 22:37
 */
public class Sum {

    public static int add(int[] arr,int index){
        if (arr.length == index){
            return 0;
        }
        return arr[index] + add(arr,index + 1);
    }

    public static void main(String[] args) {
        fibonacci(10);
        int sum = sum(10);
        System.out.println(sum);
    }

    public static void fibonacci(int length){
        int i = 1;
        int next = 0;
        int sum = 0;
        for (int j = 0; j < length; j++) {
            System.out.print(next + " ");
            sum = sum(sum,next);
            next = i + next;
            i = next - i;
        }
        System.out.println();
        System.out.println(sum);
        System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);
    }

    public static int sum(int a , int b){
        return a + b;
    }

    public static int sum(int a){
        if (a == 0){
            return 0;
        }
        return a + sum(--a);
    }



}
