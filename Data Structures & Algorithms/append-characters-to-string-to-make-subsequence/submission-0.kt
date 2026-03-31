class Solution {
    fun appendCharacters(s: String, t: String): Int {
        var sIndex = 0
        var tIndex = 0
        /*
            s="coaching"
            t="coding" 
            at index 2 (bcause we incremented twice for c and o)
        */

        while (sIndex < s.length && tIndex < t.length) {
            // check if char is equal at curr iteration
            if (s[sIndex] == t[tIndex]) {
                tIndex++
            }
            sIndex++
        }
        // if we are here, we either got to end of s or t
        if (tIndex == t.length) {
            // means t is a subsequence of s
            return 0
        } else {

            return t.length - tIndex
        }
    }
}
