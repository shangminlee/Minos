package cm.xxx.minos.data.struct;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-15 10:22
 */
public class SchemaTest {

    static String[] symbol = {"▧","▦"};

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(()->{
            try {
                out(100,8,1);
                out(100,8,2);
                out(100,8,3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        exec.shutdown();

    }

    public static int sum(int length){
        int start = 1  , next = 1;
        int sum = 2;
        for (int i = 0 ; i < length - 2 ; i++){
            next = next + start;
            start = next - start;
            sum += next;
        }
        return sum;
    }

    public static void out(long sleep,int length,int n) throws Exception{
        int temp = 0;
        for (int i = 0 ;i < length;i++) {
            for (int j = 0; j < n; j++) {
                Thread.sleep(sleep);
                System.out.print("-");
            }
            n = n + temp;
            temp = n - temp;
            Thread.sleep(sleep);
            System.out.print(symbol[temp%2]);
        }
        System.out.println();
    }


}
