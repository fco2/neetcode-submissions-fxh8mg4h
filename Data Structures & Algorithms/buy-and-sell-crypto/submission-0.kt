class Solution {
    // Track the cheapest price seen so far and compare each later price against it.
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) {
            return 0
        }

        var low = 0
        var high = 1
        var gain = 0

        while (high < prices.size) {
            // Found a better day to buy, so reset the low pointer.
            if (prices[high] < prices[low]) {
                low = high
            } else {
                // Current day is a valid sell candidate; keep the best profit seen.
                gain = maxOf(gain, prices[high] - prices[low])
            }
            high++
        }
        return gain
    }
}
