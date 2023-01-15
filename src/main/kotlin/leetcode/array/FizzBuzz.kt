package leetcode.array

/*
 * https://leetcode.com/problems/fizz-buzz/
 */

class FizzBuzz {
    fun fizzBuzz(n: Int): List<String> {
        val result = mutableListOf<String>()
        repeat(n) {
            val num = it + 1
            val element = when {
                num % 3 == 0 && num % 5 == 0 -> "FizzBuzz"
                num % 3 == 0 -> "Fizz"
                num % 5 == 0 -> "Buzz"
                else -> num.toString()
            }
            result.add(element)
        }
        return result
    }
}