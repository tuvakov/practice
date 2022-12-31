package leetcode.linkedlist

import leetcode.ListNode

class SortLinkedList {

    fun sortLinkedList(head: ListNode?): ListNode? {
        var current = head
        val list = mutableListOf<Int>()
        while (current != null) {
            list.add(current.`val`)
            current = current.next
        }

        list.sort()

        var idx = 0
        current = head
        while (current != null) {
            current.`val` = list[idx++]
            current = current.next
        }

        return head
    }

    fun sortLinkedListSelectionSort(head: ListNode?): ListNode? {
        var current = head

        while (current != null) {
            var next = current.next
            var min = current
            while (next != null) {
                if (next.`val` < min?.`val`!!) min = next
                next = next.next
            }

            val temp = current.`val`
            current.`val` = min!!.`val`
            min.`val` = temp
            current = current.next
        }

        return head
    }

    fun sortLinkedListMergeSort(head: ListNode?): ListNode? {

        if (head?.next == null) return head

        val middleNode = findMiddleNode(head)
        val middleNext = middleNode?.next
        middleNode?.next = null

        val left = sortLinkedListMergeSort(head)
        val right = sortLinkedListMergeSort(middleNext)

        return merge(left, right)
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

    private fun merge(
        list1: ListNode?,
        list2: ListNode?
    ): ListNode? {

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
}
