/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyNode = ListNode(-1)
        var curr = dummyNode
        var carry = 0
        var p1 = l1
        var p2 = l2

        while (p1 != null || p2 != null || carry != 0) {
            // p1 or p2 can be null here
            val v1 = p1?.`val` ?: 0
            val v2 = p2?.`val` ?: 0
            val sum = v1 + v2 + carry

            // testing..
            println("v1: $v1 | v2: $v2 | carry: $carry")
            // calculate new carry
            carry = sum/10
            val rem = sum%10 // for ex. if 8 + 7 = 15, 15%10=5

            // testing..
            println("NEW carry: $carry | rem: $rem")

            curr.next = ListNode(rem)
            // move curr ptr
            curr = curr.next!!
            // move p1 and p2
            p1 = p1?.next
            p2 = p2?.next
        }
        //return dummyNode next
        return dummyNode?.next
    }
}
