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
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        int i = 1;
        ListNode *p = head;
        ListNode *q = p;
        while(p != NULL && i < m) {
            p = p->next;
            i++;
        }
        stack<int> s;
        while(p != NULL && i <= n) {
            s.push(p->val);
            p = p->next;
            i++;
        }
        i = 1;
        p = q;
        while(p != NULL && i < m) {
            p = p->next;
            i++;
        }
        while(p != NULL && i <= n) {
            p->val = s.top();
            s.pop();
            p = p->next;
            i++;
        }
        return q;
    }
};