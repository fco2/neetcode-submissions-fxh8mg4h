class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val topFreqCountMap = mutableMapOf<Int, Int>()
       for (num in nums) {
         val currentElement = topFreqCountMap[num] ?: 0
         topFreqCountMap[num] = currentElement + 1
       }
       val result = topFreqCountMap.entries.sortedByDescending { it.value }.take(k).map { it.key }
       return result.toIntArray()
    }
}