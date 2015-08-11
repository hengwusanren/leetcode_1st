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
        ListNode *p, *q, *qpre, *r;
        qpre = NULL;
        p = head->next;
        q = new ListNode(head->val);
        r = q;
        int curDupVal = head->val;
        int count = 1, n = 0;
        bool isntChanging = true;
        while(p != NULL) {
            n++;
            if(p->val != q->val) {
                if(isntChanging && n != 1) {
                    q->val = p->val;
                }
                else {
                    q->next = new ListNode(p->val);
                    qpre = q;
                    q = q->next;
                }
                count++;
                isntChanging = false;
            }
            else {
                isntChanging = true;
                //curDupVal = p->val;
            }
            p = p->next;
        }
        if(isntChanging) {
            if(qpre != NULL) qpre->next = NULL;
            else return NULL;
        }
        return count == 1 ? NULL : r;
    }
};