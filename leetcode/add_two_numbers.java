/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode revertList(ListNode s) {
        if(s == null || s.next == null)
            return s;
        
        ListNode n = revertList(s.next);
        s.next.next = s;
        s.next = null;
        
        return n;
    }
    public ListNode addNode(ListNode s, int v) {
        if(s == null) {
            s = new ListNode(v);
            return s;
        }
        s.next = new ListNode(v);
        return s.next;
        
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //ListNode p1 = revertList(l1);
        //ListNode p2 = revertList(l2);
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        ListNode sum = null, p = sum;
        int i = 0, j = 0, count = 0;
        
        while(p1 != null || p2 != null) {
            i = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + j;
            j = i / 10;
            i %= 10;
            p = addNode(p, i);
            if(count == 0) {
                count++; sum = p;
            }
            p1 = (p1 == null ? null : p1.next);
            p2 = (p2 == null ? null : p2.next);
        }
        if(j != 0)
            addNode(p, j);
        
        return sum;
    }
}