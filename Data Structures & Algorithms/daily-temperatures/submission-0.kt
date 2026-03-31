class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size) { 0 } // init to 0s
        
        val stack = ArrayDeque<DailyEntry>()
        
        temperatures.forEachIndexed { i, temp ->
            while (stack.isNotEmpty() && temp > stack.last().temp) {
                val lastItem = stack.removeLast()
                // get how many days before next higher temp
                result[lastItem.index] = i - lastItem.index
            }
            // no longer popping, push current item to stack
            stack.addLast(DailyEntry(temp, i))
        }
        return result
    }
}

data class DailyEntry(val temp: Int, val index: Int)
