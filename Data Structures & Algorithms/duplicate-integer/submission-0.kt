class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val numbersSet = mutableSetOf<Int>()
        for (num in nums) {
            if (numbersSet.contains(num)) {
                // found duplicate
                return true
            } else {
                numbersSet.add(num)
            }
        }
        return false
    }
}
