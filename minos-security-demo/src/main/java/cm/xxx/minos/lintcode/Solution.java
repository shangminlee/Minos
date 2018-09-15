package cm.xxx.minos.lintcode;

public class Solution {

    private final static int[] CHANGE_WALLET = {100,50,20,10,5,2,1};

    /**
     * @param n: The guest paid
     * @param m: the price
     * @return: the sum of the number of banknotes
     */
    public int coinProblem(int n, int m) {
        if (m > n ) throw new IllegalArgumentException("paid must larger than price");
        int change = n - m;
        int sum = 0;
        if(change > 100){
            sum += change/100;
            change = change % 100;
        }
        while (change != 0){
            int div = change % 10;
            if(div >= 5){
                sum += div / 5;
                div = div % 5;
            }
            if(div >= 2) {
                sum += div / 2;
            }
            sum += div % 2;
            change /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.coinProblem(1000,612);
    }
}
