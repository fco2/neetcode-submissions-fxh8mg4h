class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val sMap = mutableMapOf<Char, Int>() // 
        for (value in s) {
            val currVal = sMap[value] ?: 0
            sMap[value] = currVal + 1
        }

        for (key in t) {
            val currVal = sMap[key] ?: 0
            if (currVal == 0) {
                return false
            } else if (currVal == 1) {
                sMap.remove(key)
            } else {
                sMap[key] = currVal - 1
            }
        }
        
        /*for ((k, v) in sMap) {
            if (v != 0) {
                return false
            }
        }
        return true */
        return sMap.isEmpty()
    }
}
