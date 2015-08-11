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
    void quickSort(vector<ListNode *> &arr, int left, int right) {
        if(left >= right) return;
        int middle = arr[(left + right + 1) / 2]->val;
        int i = left - 1, j = right + 1;
        while(1) {
            while(arr[++i]->val < middle && i < right);
            while(arr[--j]->val > middle && j > left);
            if(i >= j) break;
            ListNode *t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        quickSort(arr, left, i - 1);
        quickSort(arr, j + 1, right);
    }
    void bubbleSort(vector<ListNode *> &arr, int size, int begin) {
        if(begin >= size - 1 || arr[begin]->val <= arr[begin + 1]->val) return;
        ListNode *t = arr[begin];
        arr[begin] = arr[begin + 1];
        arr[begin + 1] = t;
        bubbleSort(arr, size, begin + 1);
    }
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        if(lists.empty()) return NULL;
            
        vector<ListNode *> klists;
        vector<ListNode *>::iterator it;
        int k = 0;
        for(it = lists.begin(); it != lists.end(); it++) {
            if(*it) {
                klists.push_back(*it);
                k++;
            }
        }
        if(klists.empty()) return NULL;
        if(k == 1) return klists[0];
        ListNode *r;
        ListNode *rear;
    	vector<ListNode *> heads;
        int count = k;
        for(int i = 0; i < k; i++) {
    		heads.push_back(klists[i]);
        }
        quickSort(heads, 0, k - 1);
        r = new ListNode(heads[0]->val);
        rear = r;
        int offset = 0;
        while(count > 0 && offset < k) {
            heads[offset] = heads[offset]->next;
            if(!heads[offset]) {
                count--;
                offset++;
            } else {
                bubbleSort(heads, k, offset);
    		}
    		if(offset < k) {
                rear->next = new ListNode(heads[offset]->val);
    			rear = rear->next;
            }
        }
    
        vector<ListNode *>().swap(klists);
    	for(int i = 0; i < k; i++) delete heads[i];
        vector<ListNode *>().swap(heads);
        return r;
    }
};