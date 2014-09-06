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
import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public ListNode sortList(ListNode head) {
        int len = 0;
        ArrayList<Integer> listVals = new ArrayList<Integer>();
        ListNode n = head;
        while(n != null) {
            len++;
            listVals.add(n.val);
            n = n.next;
        }
        Collections.sort(listVals);
        n = head;
        for(int i = 0; i < len && n != null; i++) {
            n.val = listVals.get(i);
            n = n.next;
        }
        return head;
    }
}