class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var sIndex = 0
        var tIndex = 0

        while (sIndex < s.length && tIndex < t.length) {
            if (s[sIndex] == t[tIndex]) {
                // found a match
                sIndex++
                tIndex++
            } else {
                // move second pointer
                tIndex++
            }
        }
        return sIndex == s.length
    }
}
