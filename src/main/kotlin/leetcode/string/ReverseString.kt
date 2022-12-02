package leetcode.string

class ReverseString {

    fun reverseString(s: CharArray) {
        var p = 0
        var q = s.lastIndex
        while (p < q) {
            val temp = s[q]
            s[q] = s[p]
            s[p] = temp
            p++
            q--
        }
    }
}