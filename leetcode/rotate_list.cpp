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
    ListNode *rotateRight(ListNode *head, int k) {
        if(head == NULL || head->next == NULL) return head;
        ListNode *p = head;
        int len = 0;
        while(p != NULL) {
            len++;
            p = p->next;
        }
        k = k >= len ? (k % len) : k;
        p = head;
        ListNode *q;
        ListNode *h = head;
        ListNode *t = NULL;
        int i = 0;
        while(p != NULL) {
            if(i == len - k) break;
            i++;
            t = p;
            p = p->next;
        }
        if(p == NULL || i == 0) return head;
        q = p;
        while(q->next != NULL) q = q->next;
        q->next = h;
        t->next = NULL;
        return p;
    }
};