class Solution {
    fun isValid(s: String): Boolean {
        val pStack = mutableListOf<Char>()

        for (c in s) {
            if (c in listOf('(', '{', '[')) {
                pStack.add(c)
            } else {
                // its a closing parenthesis
                if (pStack.isEmpty()) {
                    // we are starting with a closing parenthesis
                    return false 
                }
                val top = pStack[pStack.size - 1]
                when {
                    c == ')' && top == '(' || 
                    c == ']' && top == '[' ||
                    c == '}' && top == '{' -> {
                        pStack.removeAt(pStack.size - 1)
                    }
                    else -> return false 
                }
            }
        }
        return pStack.isEmpty()

    }
}
