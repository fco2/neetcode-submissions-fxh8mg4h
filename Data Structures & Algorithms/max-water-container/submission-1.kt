class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1
        var result = 0
        var area: Int
        while (left < right) {
            area = (right - left) * minOf(heights[left], heights[right])
            result = maxOf(result, area)

            if (heights[left] < heights[right]) {
                left++
            } else if (heights[left] > heights[right]) {
                right--
            } else {
                // does not matter which pointer gets moved
                left++
            }
        }
        return result
    }
}
