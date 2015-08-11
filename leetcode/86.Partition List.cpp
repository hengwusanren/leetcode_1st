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
    ListNode *partition(ListNode *head, int x) {
        if(!head) return NULL;
        if(head->next == NULL) return new ListNode(head->val);
        ListNode *less = NULL;//important
        ListNode *lessp = NULL;
        ListNode *noless = NULL;
        ListNode *nolessp = NULL;
        ListNode *p = head;
        while(p) {
            if(p->val < x) {
                if(!less) {
                    less = new ListNode(p->val);
                    lessp = less;
                } else {
                    lessp->next = new ListNode(p->val);
                    lessp = lessp->next;
                }
            } else {
                if(!noless) {
                    noless = new ListNode(p->val);
                    nolessp = noless;
                } else {
                    nolessp->next = new ListNode(p->val);
                    nolessp = nolessp->next;
                }
            }
            p = p->next;
        }
        if(less) {
            lessp->next = noless;
            return less;
        }
        else return noless;
    }
};