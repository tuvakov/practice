package leetcode.string

/*
 *  https://leetcode.com/problems/group-anagrams/
 */

class GroupAnagrams {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val map = mutableMapOf<String, MutableList<String>>()

        for (str in strs) {
            val arr = str.toCharArray()
            arr.sort()
            val sorted = arr.joinToString()
            val list = map.getOrDefault(sorted, mutableListOf())
            list.add(str)
            map[sorted] = list
        }

        return map.values.toList()
    }
}