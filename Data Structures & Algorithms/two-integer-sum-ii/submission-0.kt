class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var index1 = 0
        var index2 = numbers.size - 1

        while (index1 < index2) {
            if ((numbers[index1] + numbers[index2]) > target) {
                // reduce total
                index2--
            } else if ((numbers[index1] + numbers[index2]) < target) {
                // incremeent
                index1++
            } else {
                return intArrayOf(index1 + 1, index2 + 1)
            }
        }
        return intArrayOf()
    }
}
