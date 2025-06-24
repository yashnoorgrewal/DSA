/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //copy the value of the next node to the targeted node
        node.val = node.next.val;

        //skip the next node
        node.next = node.next.next;
    }
}