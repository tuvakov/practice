package leetcode

/* LinkedList */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun generateLeetLinkedList(arr: IntArray, loopIdx: Int = -1): ListNode {
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

fun printLinkedList(head: ListNode?) {
    var current = head
    print("[")
    while (current != null) {
        print("${current.`val`}")
        if (current.next != null) print(", ")
        current = current.next
    }
    println("]")
}

/* Tree */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}