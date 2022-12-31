package leetcode.linkedlist

import leetcode.ListNode

/*
 * https://leetcode.com/problems/merge-two-sorted-lists
 */

class MergeSortedLinkedList {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail: ListNode? = dummy
        var head1 = list1
        var head2 = list2

        while (head1 != null && head2 != null) {
            if (head1.`val` < head2.`val`) {
                tail?.next = head1
                head1 = head1.next
            } else {
                tail?.next = head2
                head2 = head2.next
            }
            tail = tail?.next
        }

        if (head1 != null) tail?.next = head1

        if (head2 != null) tail?.next = head2

        return dummy.next
    }

    fun mergeTwoList2(
        list1: ListNode?,
        list2: ListNode?
    ): ListNode? {
        if (list1 == null && list2 == null) return null

        if (list1 == null) return list2

        if (list2 == null) return list1

        var head1 = list1
        var head2 = list2

        val head: ListNode?

        if (head1.`val` < head2.`val`) {
            head = ListNode(head1.`val`)
            head1 = head1.next
        } else {
            head = ListNode(head2.`val`)
            head2 = head2.next
        }

        var last = head

        while (head1 != null || head2 != null) {

            if (head1 == null) {
                last?.next = ListNode(head2!!.`val`)
                head2 = head2.next
            } else if (head2 == null) {
                last?.next = ListNode(head1.`val`)
                head1 = head1.next
            } else if (head1?.`val` < head2.`val`) {
                last?.next = ListNode(head1.`val`)
                head1 = head1.next
            } else {
                last?.next = ListNode(head2.`val`)
                head2 = head2.next
            }

            last = last?.next
        }

        return head
    }
}