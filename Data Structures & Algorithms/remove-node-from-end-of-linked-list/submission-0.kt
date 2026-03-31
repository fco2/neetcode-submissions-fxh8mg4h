/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var dummy: ListNode? = ListNode(-1).also {
            it.next = head
        }
        var left: ListNode? = dummy
        var right: ListNode? = head // head + n NOT tail + n, as i thought
        var nIndex = n

        while (nIndex > 0 && right != null) {
            right = right.next
            nIndex--
        }

        // shift both right and left nodes
        while (right != null) {
            right = right.next
            left = left?.next
        }

        // left is where we want to shift ptr
        left?.next = left?.next?.next
        return dummy?.next
    }
}
