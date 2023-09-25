import linkedlist.LeetCodeExercises
import linkedlist.LinkedList

fun main(args: Array<String>) {
    // linkedList()
    println(LeetCodeExercises().needleIndexInHaystack(
        haystack = "mississippi",
        needle = "issip"
    ))
}


private fun linkedList() {
    // Create LinkedList
    val linkedList = LinkedList(1)

    // Append Numbers
    linkedListAppendNumbers(linkedList)
    println("Appending numbers")
    linkedList.printLinkedList()
    println("")

    // Prepend Numbers
    linkedListPrependNumbers(linkedList)
    println("Prepending numbers")
    linkedList.printLinkedList()
    println("")

    // Remove Last
    linkedList.linkedListRemoveLastNode()
    println("Removing last number")
    linkedList.printLinkedList()
    println("")

    // Remove First
    linkedList.linkedListRemoveFirstNode()
    println("Removing first number")
    linkedList.printLinkedList()
    println("")

    // Insert Number by Index
    linkedList.insertNodeByIndex(1993, 5)
    println("Inserting number by index")
    linkedList.printLinkedList()
    println("")

    // Remove Number By Index
    linkedList.removeNodeByIndex(5)
    println("Removing number by index")
    linkedList.printLinkedList()
    println("")

    // Sort
    linkedList.sortLinkedList()
    println("Sorting the linkedList")
    linkedList.printLinkedList()
    println("")

    // Invert
    linkedList.invertLinkedList()
    println("Inverting the linkedList")
    linkedList.printLinkedList()
    println("")
}

private fun linkedListAppendNumbers(linkedList: LinkedList) {
    linkedList.linkedListAppendNode(10)
    linkedList.linkedListAppendNode(11)
    linkedList.linkedListAppendNode(2324)
    linkedList.linkedListAppendNode(5464)
    linkedList.linkedListAppendNode(76453)
    linkedList.linkedListAppendNode(534543)
}

private fun linkedListPrependNumbers(linkedList: LinkedList){
    linkedList.linkedListPrependNode(1)
    linkedList.linkedListPrependNode(2)
    linkedList.linkedListPrependNode(3)
    linkedList.linkedListPrependNode(4)
    linkedList.linkedListPrependNode(5)
    linkedList.linkedListPrependNode(6)
}