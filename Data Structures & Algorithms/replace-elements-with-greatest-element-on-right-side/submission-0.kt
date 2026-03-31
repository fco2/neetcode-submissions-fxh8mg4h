class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        val n = arr.size
        val result = IntArray(arr.size)
        var rightMax = -1
        for (i in (n - 1) downTo 0) {
            result[i] = rightMax
            rightMax = maxOf(rightMax, arr[i])
        }
        return result
    }
}
