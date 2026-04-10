class Solution {

    fun encode(strs: List<String>): String {
        val sb = StringBuilder()

        for (str in strs) {
            sb.append("${str.length}#${str}")
        }
        return sb.toString()
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0; var j = 0

        while (i < str.length) {
            j = i
            while (str[j] != '#') {
                // move j pointer until we get to the delimiter
                j++
            }
            val wordCount = str.substring(i, j).toInt()
            val nextWord = str.substring(j + 1, j + 1 + wordCount)
            result.add(nextWord)
            // set the new i
            i = j + 1 + wordCount
        }
        return result
    }
}
