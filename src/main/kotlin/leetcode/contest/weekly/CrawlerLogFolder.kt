package leetcode.contest.weekly

import java.util.*

/*
 * Link: https://leetcode.com/problems/crawler-log-folder/
 */

class CrawlerLogFolder {
    fun minOperations(logs: Array<String>): Int {
        val stack = Stack<String>()
        for (log in logs) {
            if (log == "./") continue
            else if (log == "../") {
                if (stack.isNotEmpty()) stack.pop()
            } else stack.push(log)
        }
        return stack.size
    }
}