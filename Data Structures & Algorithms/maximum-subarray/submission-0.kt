class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.size == 0) {
            return 0
        }
        var maxSum = nums[0]
        var currSum = 0

        for (rightIndex in nums.indices) {
            currSum = nums[rightIndex] + currSum
            maxSum = maxOf(maxSum, currSum)
            if (currSum < 0) {
                currSum = 0
            }
        }
        return maxSum

    }
}
