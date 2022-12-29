package leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun generateLeetLinkedList(arr: IntArray, loopIdx: Int): ListNode {
    val head = ListNode(arr.first())
    var prev = head
    var loopStartNode: ListNode? = null
    for (idx in 1..arr.lastIndex) {
        val node = ListNode(arr[idx])
        if (idx == loopIdx) loopStartNode = node
        prev.next = node
        prev = node
    }
    prev.next = if (loopIdx == 0) head else loopStartNode
    return head
}