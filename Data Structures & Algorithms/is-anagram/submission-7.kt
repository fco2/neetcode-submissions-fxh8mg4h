class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val sMap = mutableMapOf<Char, Int>() // 

        val charCount = IntArray(26)// a - z, initialized to all 0s

        for (i in s.indices) {
            // iterate over both strings
            // add char from s
            // subtract char from t
            val indexS = s[i] - 'a'
            val indexT = t[i] - 'a'
            charCount[indexS]++
            charCount[indexT]--
        }

        return (charCount.maxOrNull() ?: 0) == 0

        /*for (value in s) {
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
        
        return sMap.isEmpty()*/
    }
}
