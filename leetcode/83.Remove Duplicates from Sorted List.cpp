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
    ListNode *deleteDuplicates(ListNode *head) {
        if(head == NULL || head->next == NULL) return head;
        ListNode *p, *q, *r;
        p = head->next;
        q = new ListNode(head->val);
        r = q;
        while(p != NULL) {
            if(p->val != q->val) {
                q->next = new ListNode(p->val);
                q = q->next;
            }
            p = p->next;
        }
        return r;
    }
};