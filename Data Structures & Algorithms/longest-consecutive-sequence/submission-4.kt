class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var longestSeq = 0

        val numSet = nums.toMutableSet()

        for (num in nums) {
           if (!numSet.contains(num - 1)) {
                // means its start of a sequence
                var length = 0
                while (numSet.contains(num + length)) {
                    length++
                }
                longestSeq = maxOf(longestSeq, length)
           }
           
        }
        return longestSeq
    }
}
