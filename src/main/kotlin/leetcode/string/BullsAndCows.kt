package leetcode.string


/*
 * https://leetcode.com/problems/bulls-and-cows/
 */

class BullsAndCows {

    fun getHint(secret: String, guess: String): String {

        val mapSecret = mutableMapOf<Char, Int>()
        secret.groupingBy { it }.eachCountTo(mapSecret)

        val mapGuess = mutableMapOf<Char, Int>()
        guess.groupingBy { it }.eachCountTo(mapGuess)

        var cows = 0
        for (idx in secret.indices) {
            if (secret[idx] != guess[idx]) continue

            cows++

            val char = secret[idx]
            mapSecret[char] = mapSecret[char]!! - 1
            mapGuess[char] = mapGuess[char]!! - 1
        }

        var bulls = 0
        mapGuess.forEach { (char, guessCount) ->
            if (char !in mapSecret || guessCount <= 0) return@forEach
            val secretCount = mapSecret[char]!!
            bulls += minOf(secretCount, guessCount)
        }

        return "${cows}A${bulls}B"
    }
}