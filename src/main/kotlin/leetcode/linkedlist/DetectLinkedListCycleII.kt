package leetcode.linkedlist

import leetcode.ListNode

/*
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */

class DetectLinkedListCycleII {

    fun detectCycleFloyd(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (slow != null && fast != null) {
            slow = slow.next
            fast = fast.next?.next
            if (slow == fast) break
        }

        if (fast == null) return null

        var intersection = head

        while (slow != null) {
            if (intersection == slow) break
            slow = slow.next
            intersection = intersection?.next
        }

        return intersection
    }

    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head?.next
        while (slow != null && fast != null) {
            if (slow == fast) break
            slow = slow.next
            fast = fast.next?.next
        }

        if (fast == null) return null

        return getIntersection(head!!, fast)
    }

    private fun getIntersection(
        head: ListNode,
        tail: ListNode
    ): ListNode {

        var nodeA = head
        var countA = 1
        while (nodeA != tail) {
            nodeA = nodeA.next!!
            countA++
        }

        var nodeB: ListNode = tail.next!!
        var countB = 2

        while (nodeB != tail) {
            nodeB = nodeB.next!!
            countB++
        }

        nodeA = head
        nodeB = tail

        while (countA > countB) {
            countA--
            nodeA = nodeA.next!!
        }

        while (countB > countA) {
            countB--
            nodeB = nodeB.next!!
        }

        while (nodeA != nodeB) {
            nodeA = nodeA.next!!
            nodeB = nodeB.next!!
        }

        return nodeA
    }
}