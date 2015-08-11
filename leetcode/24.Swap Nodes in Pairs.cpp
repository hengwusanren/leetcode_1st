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
    ListNode *swapPairs(ListNode *head) {
        if(!head || !head->next) return head;
        ListNode *p;
        p = head->next;
        ListNode *q;
        q = head;
        q->next = NULL;
        head = p;

        bool odd = false;
        ListNode *t;
        while(p->next) {
            if(!p->next->next) {
                odd = true;
                break;
            }

            q->next = p->next;
            p->next = q;
            t = q->next;
            p = t->next;
            q->next = p;
            q = t;
            q->next = NULL;
        }

        if(odd) {
            q->next = p->next;
            p->next = q;
        } else {
            p->next = q;
        }

        return head;
    }
};