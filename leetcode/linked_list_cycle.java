/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.HashSet;
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodeHistory = new HashSet<ListNode>();
        if(head == null) return false;
        nodeHistory.add(head);
        head = head.next;
        while(head != null) {
            if(nodeHistory.contains(head)) return true;
            nodeHistory.add(head);
            head = head.next;
        }
        return false;
    }
}