package leetcode.linkedlist

import leetcode.ListNode

class EvenOddLinkedList {

    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return null

        var tail = head
        while (tail?.next != null) {
            tail = tail.next
        }

        var oddHead = head

        val dummy = ListNode(0)
        var evenHead: ListNode? = dummy

        while (oddHead != null) {

            val even = oddHead.next

            oddHead.next = even?.next
            oddHead = oddHead.next

            even?.next = null

            evenHead?.next = even
            evenHead = evenHead?.next
        }


        tail = head
        while (tail?.next != null) {
            tail = tail.next
        }

        tail?.next = dummy.next

        return head
    }
}