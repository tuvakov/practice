package leetcode.string

/**
 * https://leetcode.com/problems/letter-case-permutation/
 */

class LetterCasePermutation {

    fun letterCasePermutation(s: String): List<String> {
        val list = mutableListOf<String>()
        letterCasePermutation(s.toCharArray(), 0, list)
        return list
    }

    private fun letterCasePermutation(
        charArray: CharArray,
        idx: Int,
        list: MutableList<String>
    ) {
        if (idx > charArray.lastIndex) {
            list.add(String(charArray))
            return
        }

        if (charArray[idx].isDigit()) {
            letterCasePermutation(charArray, idx + 1, list)
            return
        }

        val char = charArray[idx]

        charArray[idx] = char.toLowerCase()
        letterCasePermutation(charArray, idx + 1, list)

        charArray[idx] = char.toUpperCase()
        letterCasePermutation(charArray, idx + 1, list)
    }
}
