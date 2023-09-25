package linkedlist

class LeetCodeExercises {
    fun getIntersectionNode(headA: LinkedList.Node?, headB: LinkedList.Node?): LinkedList.Node? {
        val visitedNodes = mutableSetOf<LinkedList.Node?>()

        var currentNodeA = headA
        var currentNodeB = headB

        while (currentNodeA != null) {
            visitedNodes.add(currentNodeA)
            currentNodeA = currentNodeA.nextNode
        }

        while (currentNodeB != null) {
            if (visitedNodes.contains(currentNodeB)) {
                return currentNodeB
            }
            currentNodeB = currentNodeB.nextNode
        }

        return null
    }
}
