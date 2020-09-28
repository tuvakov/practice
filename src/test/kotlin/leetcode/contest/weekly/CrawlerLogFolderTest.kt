package leetcode.contest.weekly

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CrawlerLogFolderTest {

    val subject = CrawlerLogFolder()

    @Test
    fun test1() {
        val logs = arrayOf("./", "../", "./")
        val expected = 0
        val output = subject.minOperations(logs)
        assertEquals(expected, output)
    }
}