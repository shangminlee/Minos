package cm.xxx.minos;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-10 09:29
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws Exception{

        int result = factorial(21);
        log.info("result:{}",result);

        int power = power(2);
        log.info("power:{}",power);

        fibonacci(4,20);
    }

    public static void fibonacci(int start,int length){
        int next = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            next = start + next;
            start = next - start;
            linkedList.addLast(next);
        }
        log.info("Fibonacci:{}",linkedList);
    }

    public static int factorial(int n) throws Exception{
        if(n == 1){
            return n;
        }
        return n * factorial(n -1);
    }

    public static int power(int v ){
        return 2 << v;
    }

    public static int div(long s , int d){
        return (new BigDecimal(s)).divide(new BigDecimal(d),BigDecimal.ROUND_DOWN).intValue();
    }
}
