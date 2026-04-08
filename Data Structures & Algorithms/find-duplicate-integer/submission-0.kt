class Solution {
    /*
    example: nums=[1,2,3,2,2]
    step 0: slow = fast = slow2 = 0 (this is index 0)
    step 1: slow = 2 (the value of index 1)
            fast = 3 ( the value of jumping to index 1, then index 2)
    step 2: slow = 3 ( the value of index 2)
            fast = 3 ( the value from -> index 3 -> index 2)
    */
    fun findDuplicate(nums: IntArray): Int {
        // slow/fast ptrs using floyds algorithm
        var slow = 0
        var slow2 = 0
        var fast = 0

        while (true) {
            slow = nums[slow] // move one step
            fast = nums[nums[fast]] // move 2 steps

            if (slow == fast) break
        }

        // take the second slow ptr and advance one step at a time
        while (true) {
            slow2 = nums[slow2] // move slow2 by 1
            slow = nums[slow] // move slow by 1

            // where they meet is the duplicate
            if (slow == slow2) return slow 
        }
    }
}
