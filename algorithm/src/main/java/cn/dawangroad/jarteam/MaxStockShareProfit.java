package cn.dawangroad.jarteam;

/**
 * @author zhiyingyang
 * @version 2018-12-20 11:51
 */
public class MaxStockShareProfit {

    public static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < len; i++) {
            if (buy < sell - prices[i]) {
                buy = sell - prices[i];
            } else {
                sell = Math.max(sell, buy + prices[i] - fee);
            }
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(prices, 2));
    }

}
