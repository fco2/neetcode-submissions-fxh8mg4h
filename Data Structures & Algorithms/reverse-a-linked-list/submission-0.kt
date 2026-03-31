/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        // For ex: head -> 1 -> 2 -> 3 -> 4
        // should be: head -> 4 -> 3 -> 2 -> 1
        if (head == null) return null
        var currNode = head
        var prev: ListNode? = null

        while (currNode != null) {
            // we want currNode.next = newPrev
            val tempNode = currNode.next
            currNode.next = prev
            prev = currNode
            // also important, currNode becomes currNode.next here
            currNode = tempNode // currNode is null when we exit loop
        }
        return prev // which is the currNode
    }
}
