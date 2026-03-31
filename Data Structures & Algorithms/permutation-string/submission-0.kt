class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) return false

        val s1Count = IntArray(26)
        val windowCount = IntArray(26)

        // Populate frequency arrays for s1 and the first window of s2
        for (i in s1.indices) {
            s1Count[s1[i] - 'a']++
            windowCount[s2[i] - 'a']++
        }

        if (s1Count.contentEquals(windowCount)) return true

        // Slide the window: bring in the new right char, drop the old left char
        for (end in s1.length until s2.length) {
            val start = end - s1.length
            windowCount[s2[end] - 'a']++
            windowCount[s2[start] - 'a']--
            if (s1Count.contentEquals(windowCount)) return true
        }

        return false
    }
}
