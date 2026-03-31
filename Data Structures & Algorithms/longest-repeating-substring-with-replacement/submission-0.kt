class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val freqMap = HashMap<Char, Int>()
        var left = 0
        var result = 0

        for (right in s.indices) {
            // Expand the window by counting the actual character at `right`.
            // Your original code used `s[right] + 1` as the key, which updates the
            // next character in the ASCII table instead of the current one.
            freqMap[s[right]] = freqMap.getOrDefault(s[right], 0) + 1

            val maxCount =  freqMap.values.maxOrNull() ?: 0
            while ((right - left + 1) - maxCount > k) {
                // Shrink the window by removing the actual character at `left`.
                // Your original code used `s[left] - 1`, which looks up a different
                // character instead of decrementing the count for `s[left]`.
                freqMap[s[left]] = freqMap.getOrDefault(s[left], 0) - 1
                left++
            }

            result = maxOf(result, right - left + 1)
        }

        return result
    }
}
