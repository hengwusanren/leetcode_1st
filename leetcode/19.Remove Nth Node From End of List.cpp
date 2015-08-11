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
    void passList(ListNode *head, vector<ListNode *> &history, int &len) {
        len = 0;
        if(!head) return;
        
        ListNode *p;
        p = head;
        while(p) {
            len++;
            history.push_back(p);
            p = p->next;
        }
    }
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        int len = 0;
        vector<ListNode *> history;
        passList(head, history, len);
        if(len == 1) return NULL;
        if(n == len) {
            history.at(0)->next = NULL;
            return history.at(1);
        }
        if(n == 1) {
            history.at(len - 2)->next = NULL;
            return history.at(0);
        }
        history.at(len - n - 1)->next = history.at(len - n + 1);
        history.at(len - n)->next = NULL;
        return head;
    }
};