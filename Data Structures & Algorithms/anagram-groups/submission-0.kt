class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val anagramsMap = mutableMapOf<List<Int>, MutableList<String>>()

        for (str in strs) {
            // eg. act
            val intArr = IntArray(26) { 0 }
            for (c in str) {
                val index = c - 'a' // because a - a == 0, b - a == 1
                intArr[index]++ // increment its count
            }
            // first retrieve the mutableList value if exists
            val key = intArr.toList()
            val listOfAnagrams = anagramsMap[key] ?: mutableListOf<String>()
            listOfAnagrams.add(str)
            // add to hashMap
            anagramsMap[key] = listOfAnagrams
        }
        val listOfLists: MutableList<List<String>> = mutableListOf()
        for ((k, v) in anagramsMap) {
            listOfLists.add(v)
        }
        return listOfLists
    }
}