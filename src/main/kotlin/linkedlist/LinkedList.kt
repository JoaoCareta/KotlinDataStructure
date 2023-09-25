package linkedlist

class LinkedList(private var value: Int) {
    private var linkedListHead: Node?
    private var linkedListTail: Node?
    private var linkedListLength: Int = 0

    init {
        val newNode = Node(this.value)
        this.linkedListHead = newNode
        this.linkedListTail = newNode
        incrementLinkedListLength()
    }

    fun linkedListAppendNode(value: Int) {
        val newNode = Node(value)
        if (linkedListLength <= 0) {
            linkedListHead = newNode
            linkedListTail = newNode
        } else {
            moveLinkedListTailPointer(newNode)
        }
        incrementLinkedListLength()
    }

    fun linkedListPrependNode(value: Int) {
        val newNode = Node(value)
        if (linkedListLength <= 0) {
            linkedListHead = newNode
            linkedListTail = newNode
        } else {
            moveLinkedListHeadPointer(newNode)
        }
        incrementLinkedListLength()
    }

    fun linkedListRemoveLastNode() {
        if (linkedListLength > 1) {
            var currentNode: Node? = linkedListHead
            while (currentNode?.nextNode != linkedListTail) {
                currentNode = currentNode?.nextNode
            }
            linkedListTail = currentNode
            linkedListTail?.nextNode = null
            decrementLinkedListLength()
        } else {
            cleanLinkedListHeadAndTail()
        }
    }

    fun linkedListRemoveFirstNode() {
        when {
            linkedListLength > 1 -> {
                linkedListHead = linkedListHead?.nextNode
                decrementLinkedListLength()
            }
            linkedListLength == 1 -> {
                cleanLinkedListHeadAndTail()
            }
            else -> Unit
        }
    }

    fun insertNodeByIndex(value: Int, index: Int) {
        when {
            index >= linkedListLength -> linkedListAppendNode(value)
            index <= 0 -> linkedListPrependNode(value)
            else -> {
                var currentNode: Node? = linkedListHead
                var currentIndex = 0
                val targetIndex = index-1
                while (currentIndex != targetIndex) {
                    currentNode = currentNode?.nextNode
                    currentIndex += 1
                }
                val newNode = Node(value)
                newNode.nextNode = currentNode?.nextNode
                currentNode?.nextNode = newNode
            }
        }
        incrementLinkedListLength()
    }

    fun removeNodeByIndex(index: Int) {
        if (linkedListLength > 0) {
            when {
                index >= linkedListLength -> linkedListRemoveLastNode()
                index <= 0 -> linkedListRemoveFirstNode()
                else -> {
                    var currentNode: Node? = linkedListHead
                    var nodeToRemove: Node? = linkedListHead?.nextNode
                    val targetIndex = index - 1
                    var currentIndex = 0
                    while (currentIndex != targetIndex) {
                        currentNode = currentNode?.nextNode
                        nodeToRemove = nodeToRemove?.nextNode
                        currentIndex += 1
                    }
                    currentNode?.nextNode = nodeToRemove?.nextNode
                    decrementLinkedListLength()
                }
            }
        }
    }

    fun sortLinkedList() {
        if (linkedListHead == null || linkedListHead?.nextNode == null) {
            return
        }

        var isSorted: Boolean
        do {
            isSorted = true
            var currentNode = linkedListHead
            var prevNode: Node? = null

            while (currentNode?.nextNode != null) {
                if (currentNode.nodeValue > currentNode.nextNode!!.nodeValue) {
                    val temp = currentNode.nextNode
                    currentNode.nextNode = temp?.nextNode
                    temp?.nextNode = currentNode

                    if (prevNode != null) {
                        prevNode.nextNode = temp
                    } else {
                        linkedListHead = temp
                    }

                    isSorted = false
                }

                prevNode = currentNode
                currentNode = currentNode.nextNode
            }
        } while (!isSorted)
    }

    fun invertLinkedList(): LinkedList? {
        return linkedListHead?.let { head ->
            val newLinkedList = LinkedList(head.nodeValue)
            var currentNode: Node? = head.nextNode
            while (currentNode != null) {
                newLinkedList.linkedListPrependNode(currentNode.nodeValue)
                currentNode = currentNode.nextNode
            }
            newLinkedList
        }
    }

    fun printLinkedList() {
        var stringLinkedList = "["
        var nodes: Node? = linkedListHead
        while (nodes != null) {
            stringLinkedList += if (nodes.nextNode == null) {
                "${nodes.nodeValue}"
            } else {
                "${nodes.nodeValue} --> "
            }
            nodes = nodes.nextNode
        }
        stringLinkedList += "]"
        println(stringLinkedList)
    }

    private fun moveLinkedListHeadPointer(newNode: Node) {
        newNode.nextNode = linkedListHead
        linkedListHead = newNode
    }

    private fun moveLinkedListTailPointer(newNode: Node) {
        linkedListTail?.nextNode = newNode
        linkedListTail = newNode
    }

    private fun incrementLinkedListLength() {
        linkedListLength += 1
    }

    private fun decrementLinkedListLength() {
        if (linkedListLength > 0) {
            linkedListLength - 1
        }
    }

    private fun cleanLinkedListHeadAndTail() {
        linkedListHead = null
        linkedListTail = null
        decrementLinkedListLength()
    }

    inner class Node(value: Int) {
        var nodeValue: Int = value
        var nextNode: Node? = null

    }
}
