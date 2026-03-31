class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val charSet = mutableSetOf<Char>()
          var maxLen = 0
          var start = 0

          for (end in s.indices) {
              // shrink window from left until duplicate is removed
              while (charSet.contains(s[end])) {
                  charSet.remove(s[start])
                  start++
              }
              charSet.add(s[end])
              maxLen = maxOf(maxLen, end - start + 1)
          }
          return maxLen
          //Key differences:
  //- end advances via for loop — no missed increments
  //- maxLen is updated after every valid expansion, so shrinking the window never loses the best answer
  //- The while shrink loop removes from the left until the duplicate is gone, then adds s[end]
  //- Window size is always end - start + 1, so no manual counter needed
    }
}
