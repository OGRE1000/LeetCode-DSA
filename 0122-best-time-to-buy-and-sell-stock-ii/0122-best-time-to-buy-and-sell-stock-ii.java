class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int n = prices.length;
        int profit = 0;

        while (i < n - 1) {

            // Find valley (buy)
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int valley = prices[i];

            // Find peak (sell)
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int peak = prices[i];

            profit += peak - valley;
        }

        return profit;
    }
}
