package leetcode.linkedlist

import leetcode.ListNode

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {

        val middle = findMiddleNode(head)
        var secondHalf = reverseList(middle?.next)
        var firstHalf = head

        while (secondHalf != null) {
            if (firstHalf?.`val` != secondHalf.`val`) return false
            firstHalf = firstHalf.next
            secondHalf = secondHalf.next
        }

        return true
    }

    private fun findMiddleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head?.next

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }

    private fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = head

        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }

        return prev
    }
}