class Solution {
    fun countSubstrings(s: String): Int {
        var count = 0

        for (i in s.indices) {
            // odd case
            var leftOdd = i
            var rightOdd = i
            while (leftOdd >= 0 &&
                     rightOdd < s.length
                     && (s[leftOdd] == s[rightOdd])) {
                count++ // incrememt palindrome count
                leftOdd--
                rightOdd++
            }
            
            // even case
            var leftEven = i
            var rightEven = i + 1
            while (leftEven >= 0 && rightEven < s.length
                   && s[leftEven] == s[rightEven]) {
                //increment palim=ndrome count
                count++
                leftEven--
                rightEven++
            }
        }
        return count
    }
}