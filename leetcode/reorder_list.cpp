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
    void reorderList(ListNode *head) {
        ListNode *p = head;
        int len = 0;
        while(p != NULL) {
            p = p->next;
            len++;
        }
        if(len < 3) return;
        int *a = new int[len];
        int *b = new int[len];
        p = head;
        int i = 0;
        while(p != NULL) {
            a[i] = p->val;
            i++;
            p = p->next;
        }
        for(i = 0; i < len; i += 2)
            b[i] = a[i / 2];
        for(i = 1; i < len; i += 2)
            b[i] = a[len - (i + 1) / 2];
        p = head;
        i = 0;
        while(p != NULL) {
            p->val = b[i];
            i++;
            p = p->next;
        }
    }
};