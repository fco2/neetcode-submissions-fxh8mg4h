class Solution {
    fun reorganizeString(s: String): String {
        // get freq array [ 0 .. 26] for a - z lowercase ASCII
        val freq = IntArray(26)
        for (c in s) { freq[c - 'a']++ }
        // means we will never be able to replace all char
        if (freq.any { it -> it > (s.length + 1)/2 }) {
            return ""
        }

        val maxHeap = PriorityQueue<Pair<Int, Char>>(compareByDescending{ it.first })
        for (i in 0 until 26) { // excluding 26
            if (freq[i] > 0) { // means the character exists at least once
                maxHeap.offer(Pair(freq[i], 'a' + i))
            }
        }

        var previousChar: Char = Char.MIN_VALUE
        val sb = StringBuilder()
        while (maxHeap.isNotEmpty()) {
            val (count1, char1) = maxHeap.poll() // this removes the max freq

            if (char1 == previousChar) {
                // means our previous == current, so get the next highest
                val (count2, char2) = maxHeap.poll() // it will definitely be a diff char

                if (maxHeap.isEmpty()) { return "" }
                sb.append(char2)
                if ((count2 - 1) > 0) { // do we still have count of 1 or more after removal
                    maxHeap.offer(Pair(count2 - 1, char2)) // decrement it in maxHeap
                }
                //add the first char since we didnt use it
                maxHeap.offer(Pair(count1, char1))
                // assign prev
                previousChar = char2
            } else { // means we can append it
                sb.append(char1)
                if ((count1 - 1) > 0) { // now reduce its count
                    maxHeap.offer(Pair(count1 - 1, char1)) // decrement it in maxHeap
                }
                // assign prev
                previousChar = char1
            }
        }
        return sb.toString()
    }
}
