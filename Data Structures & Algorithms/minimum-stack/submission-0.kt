class MinStack() {

    private val stack = arrayListOf<Int>()
    private val minList = arrayListOf<Int>()

    fun push(item: Int) {
        stack.add(item)
        val min = minOf(minList.lastOrNull() ?: Int.MAX_VALUE, item)
        minList.add(min)
    }

    fun pop() {
        stack.removeAt(stack.lastIndex)
        minList.removeAt(minList.lastIndex)
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minList.lastOrNull() ?: return Int.MAX_VALUE
    }
}
