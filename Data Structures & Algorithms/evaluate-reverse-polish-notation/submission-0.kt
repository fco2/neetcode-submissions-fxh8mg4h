class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for (c in tokens) {
            when (c) {
                "+" -> {
                    val second = stack.removeLast().toInt()
                    val first = stack.removeLast().toInt()
                    stack.addLast(first + second)
                }
                "-" -> {
                    val second = stack.removeLast().toInt()
                    val first = stack.removeLast().toInt()
                    stack.addLast(first - second)
                    
                }
                "/" -> {
                    val second = stack.removeLast().toInt()
                    val first = stack.removeLast().toInt()
                    stack.addLast(first / second)
                    
                }
                "*" -> {
                    val second = stack.removeLast().toInt()
                    val first = stack.removeLast().toInt()
                    stack.addLast(first * second)
                    
                }
                else -> {
                    stack.addLast(c.toInt())
                }
            }
        }
        return stack.first()!!
    }
}
