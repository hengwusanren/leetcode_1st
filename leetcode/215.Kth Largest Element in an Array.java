public class Solution {
    public static void adjustMinHeap(int[] h, int k, int x) {
    	if(x <= h[0]) return;
    	h[0] = x;
    	int p = 0;
    	while(p < k) {
    		int q = 2 * p + 1;
    		if(q >= k) break;
    		if(q < k - 1 && h[q + 1] < h[q]) q = q + 1;
    		if(h[q] < h[p]) { // p有孩子比它小，交换值
    			int t = h[p];
    			h[p] = h[q];
    			h[q] = t;
    			p = q;
    		}
    		else break;
    	}
    }
    public static void buildMinHeap(int[] h, int[] s, int k) {
    	if(k < 1 || s.length < 1) return;
    	h[0] = s[0];
    	for(int i = 1; i < k; i++) {
    		h[i] = s[i];
    		int current = i;
    		int parent = (current + 1) / 2 - 1;
    		while(h[current] < h[parent]) { // 父亲比它大，交换值
    			int tmp = h[parent];
    			h[parent] = h[current];
    			h[current] = tmp;
    			current = parent;
    			if(current == 0) break;
				else parent = (current + 1) / 2 - 1;
    		}
    	}
    }
    public int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		if(len < 1) return 0;
		if(len == 1) return nums[0];
        int[] heap = new int[k];
        buildMinHeap(heap, nums, k);
		for(int i = k; i < len; i++)
			adjustMinHeap(heap, k, nums[i]);
		return heap[0];
    }
}