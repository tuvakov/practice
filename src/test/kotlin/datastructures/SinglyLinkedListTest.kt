package datastructures

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SinglyLinkedListTest {
    private lateinit var subject: SinglyLinkedList

    @BeforeEach
    fun setup() {
        subject = SinglyLinkedList()
    }

    @Test
    fun test_addFirst_singleValue() {
        subject.addFirst(1)
        val result = "[1]"
        assertEquals(result, subject.toString())
        assertEquals(1, subject.size())
    }

    @Test
    fun test_addFirst_multipleValues() {
        subject.addFirst(1)
        subject.addFirst(4)
        subject.addFirst(10)
        val result = "[10, 4, 1]"
        assertEquals(result, subject.toString())
        assertEquals(3, subject.size())
    }

    @Test
    fun test_addLast_singleValue() {
        subject.addLast(10)
        val result = "[10]"
        assertEquals(result, subject.toString())
        assertEquals(1, subject.size())
    }

    @Test
    fun test_addLast_multipleValues() {
        subject.addLast(10)
        subject.addLast(20)
        subject.addLast(30)
        subject.addLast(40)
        val result = "[10, 20, 30, 40]"
        assertEquals(result, subject.toString())
        assertEquals(4, subject.size())
    }

    @Test
    fun test_addToPosition_invalidPositions_emptyList() {
        assertFalse(subject.add(-1, 10))
        assertFalse(subject.add(10, 10))
        assertTrue(subject.size() == 0)
    }

    @Test
    fun test_addToPosition_invalidPositions_nonEmptyList() {
        subject.add(0, 10)
        subject.addFirst(11)
        subject.addLast(12)
        assertFalse(subject.add(10, 10))
        assertFalse(subject.add(-1, 10))
        assertTrue(subject.size() == 3)
    }

    @Test
    fun test_addToPosition_singleValue() {
        subject.add(0, 10)
        val result = "[10]"
        assertEquals(result, subject.toString())
        assertEquals(1, subject.size())
    }

    @Test
    fun test_addToPosition_multipleValuesOrderly() {
        subject.add(0, 10)
        subject.add(1, 12)
        subject.add(2, 14)
        subject.add(3, 16)
        subject.add(4, 18)
        val result = "[10, 12, 14, 16, 18]"
        assertEquals(result, subject.toString())
        assertEquals(5, subject.size())
    }

    @Test
    fun test_addToPosition_multipleValuesRandomly_toNonEmptyList() {
        subject.addLast(10)
        subject.addLast(12)
        subject.addLast(13)

        assertTrue(subject.add(0, 9))
        assertTrue(subject.add(4, 14))
        assertTrue(subject.add(2, 11))
        assertTrue(subject.add(6, 15))
        assertTrue(subject.add(0, 8))

        val result = "[8, 9, 10, 11, 12, 13, 14, 15]"
        assertEquals(result, subject.toString())
        assertEquals(8, subject.size())
    }

    @Test
    fun test_addOperations_inMixedOrder() {

        subject.addFirst(10)
        subject.add(0, 9)
        subject.addLast(11)

        subject.addLast(12)
        subject.add(4, 13)
        subject.addFirst(8)

        subject.addLast(14)
        subject.addLast(15)
        subject.addFirst(7)
        subject.add(0, 6)

        val result = "[6, 7, 8, 9, 10, 11, 12, 13, 14, 15]"
        assertEquals(result, subject.toString())
        assertEquals(10, subject.size())
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
        subject.addLast(11)
        subject.add(1, 12)

        assertEquals(10, subject.removeFirst())
        assertEquals(12, subject.removeFirst())

        assertEquals(1, subject.size())
        assertEquals("[11]", subject.toString())
    }

    @Test
    fun test_removeAtPosition_emptyList() {
        assertThrows(
            IllegalStateException::class.java
        ) { subject.remove(0) }

        assertThrows(
            IllegalStateException::class.java
        ) { subject.remove(2) }

        assertThrows(
            IllegalStateException::class.java
        ) { subject.remove(-10) }
    }

    @Test
    fun test_removeAtPosition_orderly() {

        for (i in 10..15) {
            subject.addLast(i)
        }

        for (i in 5 downTo 0) {
            assertEquals(10 + i, subject.remove(i))
            assertEquals(i, subject.size())
        }
    }

    @Test
    fun test_removeAtPosition_mixedOrder() {

        for (i in 10..15) {
            subject.addLast(i)
        }

        assertEquals(14, subject.remove(4))
        assertEquals(15, subject.remove(4))
        assertEquals(11, subject.remove(1))
        assertEquals(10, subject.remove(0))
        assertEquals(13, subject.remove(1))
        assertEquals(12, subject.remove(0))
        assertThrows(
            IllegalStateException::class.java
        ) { subject.remove(0) }

    }

    @Test
    fun test_removeOperationsInMixedOrder() {

        for (i in 4..10) {
            subject.addLast(i)
        }
        assertEquals(4, subject.removeFirst())
        assertEquals(9, subject.remove(4))
        assertEquals(10, subject.removeLast())
        assertEquals(8, subject.removeLast())
        assertEquals(6, subject.remove(1))
        assertEquals(5, subject.removeFirst())
        assertEquals(7, subject.removeFirst())
        assertThrows(
            IllegalStateException::class.java
        ) { subject.remove(0) }

    }

    @Test
    fun test_addAndRemoveAtPosition() {
        for (i in 10..15) {
            subject.add(0, i)
            assertEquals(1, subject.size())
            assertEquals(i, subject.remove(0))
            assertEquals(0, subject.size())

        }
    }

    @Test
    fun test_addAndRemoveOperationsInMixedOrder() {

        subject.addFirst(10)
        subject.addFirst(20)

        assertEquals(20, subject.removeFirst())
        assertEquals(10, subject.removeLast())

        subject.addLast(40)
        assertEquals(40, subject.removeLast())

        subject.addLast(40)
        assertEquals(40, subject.removeFirst())

        assertThrows(
            IllegalStateException::class.java
        ) { subject.remove(0) }


        subject.addLast(45)
        subject.addFirst(74)
        subject.add(1, 44)

        assertEquals(45, subject.remove(2))
        assertEquals(74, subject.remove(0))
        assertEquals(44, subject.removeFirst())

        assertEquals(0, subject.size())
    }

    @Test
    fun test_reverse_emptyList() {
        subject.reverse()
        assertEquals(0, subject.size())
        assertEquals(subject.toString(), "[]")
    }

    @Test
    fun test_reverse_singleElement() {
        subject.add(0, 1)
        subject.reverse()
        assertEquals(1, subject.size())
        assertEquals(subject.toString(), "[1]")
    }

    @Test
    fun test_reverse_multipleElement() {
        for (i in 1..5) {
            subject.addLast(i)
        }
        subject.reverse()
        assertEquals(5, subject.size())
        assertEquals(subject.toString(), "[5, 4, 3, 2, 1]")
    }

    @Test
    fun test_reverseThenAdd() {
        for (i in 1..5) {
            subject.addLast(i)
        }
        subject.reverse()
        for (i in 6..10) {
            subject.addFirst(i)
        }
        assertEquals(10, subject.size())
        assertEquals(subject.toString(), "[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]")
    }

    @Test
    fun test_reverseThenAddThenReverseThenRemove() {
        for (i in 1..5) {
            subject.addLast(i)
        }
        subject.reverse()
        for (i in 6..10) {
            subject.addFirst(i)
        }
        subject.reverse()
        for (i in 1..5) {
            subject.removeLast()
        }
        assertEquals(5, subject.size())
        assertEquals(subject.toString(), "[1, 2, 3, 4, 5]")
    }

    @Test
    fun test_recursiveReverse_emptyList() {
        subject.recursiveReverse()
        assertEquals(0, subject.size())
        assertEquals(subject.toString(), "[]")
    }

    @Test
    fun test_recursiveReverse_singleElement() {
        subject.add(0, 1)
        subject.recursiveReverse()
        assertEquals(1, subject.size())
        assertEquals(subject.toString(), "[1]")
    }

    @Test
    fun test_recursiveReverse_multipleElement() {
        for (i in 1..5) {
            subject.addLast(i)
        }
        subject.recursiveReverse()
        assertEquals(5, subject.size())
        assertEquals(subject.toString(), "[5, 4, 3, 2, 1]")
    }

    @Test
    fun test_recursiveReverseThenAdd() {
        for (i in 1..5) {
            subject.addLast(i)
        }
        subject.recursiveReverse()
        for (i in 6..10) {
            subject.addFirst(i)
        }
        assertEquals(10, subject.size())
        assertEquals(subject.toString(), "[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]")
    }

    @Test
    fun test_recursiveReverseThenAddThenRecursiveReverseThenRemove() {
        for (i in 1..5) {
            subject.addLast(i)
        }
        subject.recursiveReverse()
        for (i in 6..10) {
            subject.addFirst(i)
        }
        subject.recursiveReverse()
        for (i in 1..5) {
            subject.removeLast()
        }
        assertEquals(5, subject.size())
        assertEquals(subject.toString(), "[1, 2, 3, 4, 5]")
    }

    @Test
    fun test_reverseAndRecursiveReverse() {
        for (i in 1..5) {
            subject.addLast(i)
        }
        subject.reverse()
        subject.recursiveReverse()
        assertEquals(subject.toString(), "[1, 2, 3, 4, 5]")
    }

    @Test
    fun test_recursionPrint_emptyList() {
        subject.recursivePrint()
    }

    @Test
    fun test_recursionPrint_multipleElements() {
        for (i in 1..10) {
            subject.addLast(i)
        }
        subject.recursivePrint()
    }

    @Test
    fun test_recursionReversePrint_emptyList() {
        subject.recursiveReversePrint()
    }

    @Test
    fun test_recursionReservePrint_multipleElements() {
        for (i in 1..10) {
            subject.addLast(i)
        }
        subject.recursiveReversePrint()
    }
}