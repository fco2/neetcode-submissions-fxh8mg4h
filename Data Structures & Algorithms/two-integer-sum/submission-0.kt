class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val remainderMap = mutableMapOf<Int, Int>()

        for ((index, value) in nums.withIndex()) {
            // check empty
            if (remainderMap.isEmpty()) {
                remainderMap[value] = index
                continue
            }
            val remainder = target - value
            // check if we have seen remainder
            if (remainderMap.containsKey(remainder)) {
                // we found the other sum
                return intArrayOf(remainderMap[remainder]!!, index)
            } else {
                remainderMap[value] = index
            }

        }
        return intArrayOf()
    }
}