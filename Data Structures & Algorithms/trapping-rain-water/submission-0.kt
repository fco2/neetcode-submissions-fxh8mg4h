class Solution {
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) {
            return 0
        }

        var left = 0
        var right = height.size - 1
        var leftMax = height[left]
        var rightMax = height[right]
        var maxWater = 0

        while (left < right) {
            if (height[left] <= height[right]) {
                left++
                leftMax = maxOf(leftMax, height[left])
                maxWater += leftMax - height[left]
            } else {
                right--
                rightMax = maxOf(rightMax, height[right])
                maxWater += rightMax - height[right]
            }
        }
        return maxWater
    }
}
