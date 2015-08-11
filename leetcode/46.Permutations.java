public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        int len = num.length;
        if(len == 0) return r;
        if(len == 1) {
        	ArrayList<Integer> head = new ArrayList<Integer>();
        	head.add(num[0]);
        	r.add(head);
        	return r;
        }
        for(int i = 0; i < len; i++) {
        	int[] otherEles = new int[len - 1];
        	int j = 0, k = 0;
        	while(j < len - 1) {
        		if(k == i) {
        			k++;
        			continue;
        		}
        		otherEles[j] = num[k];
        		j++;
        		k++;
        	}
        	List<List<Integer>> otherPerms = permute(otherEles);
        	for(List<Integer> L : otherPerms) {
        		List<Integer> tmpPerm = L;
        		tmpPerm.add(num[i]);
        		r.add(tmpPerm);
        	}
        }

        return r;
    }
}