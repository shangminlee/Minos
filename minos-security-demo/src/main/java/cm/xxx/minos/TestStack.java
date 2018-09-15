package cm.xxx.minos;

import java.util.Random;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-10 16:51
 */
public class TestStack {

    public static void main(String[] args) {
        int count  = 1000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        testStack(arrayStack,count);
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        testStack(linkedStack,count);
    }

    public static void testStack(Stack<Integer> stack,int count){
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        long end  = System.nanoTime();
        System.out.println("Spend : " + (end - start)/1000000000.0);
    }

}
