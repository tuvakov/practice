package datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class DoublyLinkedListTest {
    private lateinit var subject: DoublyLinkedList

    @BeforeEach
    fun setup() {
        subject = DoublyLinkedList()
    }

    @Test
    fun test_addFirst_singleValue() {
        subject.addFirst(1)
        val result = "[1]"
        assertEquals(result, subject.toString())
        assertEquals(result, subject.toStringReverse())
        assertEquals(1, subject.size())
    }

    @Test
    fun test_addFirst_multipleValues() {
        subject.addFirst(1)
        subject.addFirst(4)
        subject.addFirst(10)

        assertEquals(3, subject.size())

        val result = "[10, 4, 1]"
        assertEquals(result, subject.toString())

        val resultReversed = "[1, 4, 10]"
        assertEquals(resultReversed, subject.toStringReverse())
    }

    @Test
    fun test_removeFirst_emptyList() {
        assertThrows(
            IllegalStateException::class.java
        ) { subject.removeFirst() }
    }

    @Test
    fun test_removeFirst_withValues() {
        subject.addFirst(10)
        subject.addFirst(11)
        subject.addFirst(12)
        subject.addFirst(13)

        assertEquals(13, subject.removeFirst())
        assertEquals(12, subject.removeFirst())
        assertEquals(2, subject.size())
        assertEquals("[11, 10]", subject.toString())
        assertEquals("[10, 11]", subject.toStringReverse())
    }

    @Test
    fun test_addFirstRemoveFirstInMixedOrder() {
        subject.addFirst(10)
        assertEquals(10, subject.removeFirst())
        subject.addFirst(11)
        subject.addFirst(12)
        assertEquals(12, subject.removeFirst())
        subject.addFirst(13)
        assertEquals("[13, 11]", subject.toString())
        assertEquals("[11, 13]", subject.toStringReverse())
    }
}