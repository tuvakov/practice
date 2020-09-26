package datastructures

import org.jetbrains.annotations.TestOnly

interface LinkedList {
    fun size(): Int

    fun addFirst(x: Int)

    fun addLast(x: Int)

    fun add(position: Int, x: Int): Boolean

    fun replace(position: Int, x: Int): Boolean

    fun removeFirst(): Int

    fun removeLast(): Int

    fun remove(position: Int): Int

    fun clear()
}

data class SinglyLinkedListNode(
    val value: Int,
    var next: SinglyLinkedListNode?
)

data class DoublyLinkedListNode(
    val value: Int,
    var prev: DoublyLinkedListNode? = null,
    var next: DoublyLinkedListNode? = null
)

class SinglyLinkedList : LinkedList {

    private var head: SinglyLinkedListNode? = null
    private var size: Int = 0

    override fun size() = size

    override fun addFirst(x: Int) {
        val node = SinglyLinkedListNode(x, head)
        head = node
        size++
    }

    override fun addLast(x: Int) {
        add(size, x)
    }

    override fun add(position: Int, x: Int): Boolean {
        if (position < 0 || position > size)
            return false

        if (head == null || position == 0) {
            addFirst(x)
            return true
        }

        var temp: SinglyLinkedListNode? = head

        for (i in 0 until position - 1) {
            temp = temp?.next
        }

        val newNode = SinglyLinkedListNode(x, temp?.next)
        temp?.next = newNode
        size++

        return true
    }

    override fun replace(position: Int, x: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeFirst(): Int {
        if (head == null) throw IllegalStateException()
        val value = head?.value
        head = head?.next
        size--
        return value!!
    }

    override fun removeLast(): Int {
        return remove(size - 1)
    }

    override fun remove(position: Int): Int {
        toString()
        if (position < 0 || position >= size || head == null)
            throw IllegalStateException()

        if (position == 0)
            return removeFirst()

        var temp: SinglyLinkedListNode? = head

        for (i in 0 until position - 1) {
            temp = temp?.next
        }

        val value = temp?.next?.value
        temp?.next = temp?.next?.next
        size--

        return value!!
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("[")
        var copy = head?.copy()
        while (copy != null) {
            builder.append(copy.value)
            copy = copy.next
            copy?.let {
                builder.append(", ")
            }
        }
        builder.append("]")
        return builder.toString()
    }


    fun reverse() {
        var current = head
        var prev: SinglyLinkedListNode? = null
        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }
        head = prev
    }

    fun recursiveReverse() {
        recursiveReverse(null, head)
    }

    fun recursivePrint() {
        recursivePrint(head)
        println()
    }

    fun recursiveReversePrint() {
        recursiveReversePrint(head)
        println()
    }

    private fun recursivePrint(node: SinglyLinkedListNode?) {
        if (node == null) return
        print("${node.value} ")
        recursivePrint(node.next)
    }

    private fun recursiveReversePrint(node: SinglyLinkedListNode?) {
        if (node == null) return
        recursiveReversePrint(node.next)
        print("${node.value} ")
    }

    private fun recursiveReverse(
        prev: SinglyLinkedListNode?,
        me: SinglyLinkedListNode?
    ) {
        if (me == null) {
            head = prev
            return
        }
        recursiveReverse(me, me.next)
        me.next = prev
    }

}

class DoublyLinkedList : LinkedList {

    private var head: DoublyLinkedListNode? = null
    private var size = 0

    override fun size(): Int {
        return size
    }

    override fun addFirst(x: Int) {
        val new = DoublyLinkedListNode(x)
        if (head != null) {
            head?.prev = new
            new.next = head
        }
        head = new
        size++
    }

    override fun addLast(x: Int) {
        TODO("Not yet implemented")
    }

    override fun add(position: Int, x: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun replace(position: Int, x: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeFirst(): Int {
        if (head == null) {
            throw IllegalStateException("Deleting from empty list.")
        }
        val value = head?.value
        head = head?.next
        head?.prev = null
        size--
        return value!!
    }

    override fun removeLast(): Int {
        TODO("Not yet implemented")
    }

    override fun remove(position: Int): Int {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("[")
        var copy = head?.copy()
        while (copy != null) {
            builder.append(copy.value)
            copy = copy.next
            copy?.let {
                builder.append(", ")
            }
        }
        builder.append("]")
        return builder.toString()
    }

    @TestOnly
    fun toStringReverse(): String {
        var tail = head
        while (tail?.next != null) {
            tail = tail.next
        }
        val builder = StringBuilder()
        builder.append("[")
        while (tail != null) {
            builder.append(tail.value)
            tail = tail.prev
            tail?.let {
                builder.append(", ")
            }
        }
        builder.append("]")
        return builder.toString()
    }
}