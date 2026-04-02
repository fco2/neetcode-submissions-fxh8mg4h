class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
         // Use a HashSet for O(1) word lookups instead of O(n) list search                                                               
        val wordSet = wordDict.toHashSet()                                                                                               
        val dp = BooleanArray(s.length + 1)
        dp[s.length] = true // base case, last item, common in DP problems
        for (i in s.length - 1 downTo 0) {
            for (word in wordSet) {
                if (i + word.length <= s.length &&
                    word == s.substring(i, i + word.length) &&
                    dp[i + word.length] == true) {
                        // found a match
                        dp[i] = true
                        break
                    }
            }
        }                                                                                                                               
      return dp[0]
    }
}
