class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val sMap = mutableMapOf<Char, Int>()
        for (value in s) {
            val currVal = sMap[value] ?: 0
            sMap[value] = currVal + 1
        }

        for (value in t) {
            val currVal = sMap[value] ?: 0
            if (currVal == 0) {
                return false
            }
            sMap[value] = currVal - 1
        }
        
        for ((k, v) in sMap) {
            if (v != 0) {
                return false
            }
        }
        return true
    }
}
