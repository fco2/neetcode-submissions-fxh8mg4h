class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        if (nums.size < 3) {
            return listOf(listOf<Int>())
        }

        for (i in 0 until nums.size) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            var left = i + 1
            var right = nums.lastIndex

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]

                when {
                    sum < 0 -> left++
                    sum > 0 -> right--
                    else -> {
                        result.add(listOf(nums[i], nums[left], nums[right]))
                        left++
                        right--

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++
                        }

                        while (left < right && nums[right] == nums[right + 1]) {
                            right--
                        }
                    }
                }
            }
        }
        return result
    }
}
