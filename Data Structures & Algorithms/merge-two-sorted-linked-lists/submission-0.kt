/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummyHead = ListNode(-1)
        var tail: ListNode? = dummyHead // ListNode(node=5, next=null)

        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                tail?.next = l1
                l1 = l1.next
            } else {
                tail?.next = l2
                l2 = l2.next
            }
            tail = tail?.next
        }
        // check if both lists are not both null now
        if (l1 != null) {
            tail?.next = l1
        } else if (l2 != null) {
            tail?.next = l2
        }
        return dummyHead.next
    }
}
