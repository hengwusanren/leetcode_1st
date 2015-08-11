/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        if(!l1) return l2;
        if(!l2) return l1;
        if(l1->val > l2->val) return mergeTwoLists(l2, l1);
        
        ListNode *r;
        r = new ListNode(l1->val);
        ListNode *h;
        h = r;
        l1 = l1->next;
        while(l1 && l2) {
            if(l1->val <= l2->val) {
                r->next = new ListNode(l1->val);
                r = r->next;
                l1 = l1->next;
                continue;
            }
            r->next = new ListNode(l2->val);
            r = r->next;
            l2 = l2->next;
        }
        while(l1) {
            r->next = new ListNode(l1->val);
            r = r->next;
            l1 = l1->next;
        }
        while(l2) {
            r->next = new ListNode(l2->val);
            r = r->next;
            l2 = l2->next;
        }
        return h;
    }
};