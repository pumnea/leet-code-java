package buy_sell_stock;

/**
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
