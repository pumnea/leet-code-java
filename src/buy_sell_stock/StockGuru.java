package buy_sell_stock;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * @author Alex Pumnea
 */
public class StockGuru {
    public int maxProfit(int[] prices) {
        if (!isValid(prices)) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    private static boolean isValid(int[] prices) {
        return prices != null && prices.length > 1;
    }
}
