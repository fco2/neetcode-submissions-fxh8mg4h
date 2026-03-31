class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val sList = arrayListOf<Char>()
        for (i in s) {
            sList.add(i)
        }

        for (i in t) {
            if (sList.remove(i) == false) {
                return false
            }
        }
        return sList.isEmpty()
    }
}
