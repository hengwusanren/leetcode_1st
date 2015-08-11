public class Solution {
    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int middle = arr[(left + right + 1) / 2];
        int i = left - 1, j = right + 1;
        while(true)
        {
            while(arr[++i] < middle && i < right) ;
            while(arr[--j] > middle && j > left) ;
            if(i >= j)
                break;
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        quickSort(arr, left, i - 1);
        quickSort(arr, j + 1, right);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int begin, int len, int target) {
    	List<List<Integer>> r = new ArrayList<List<Integer>>();
    	if(len == 0 || begin == len || target <= 0) return r;
        if(target < candidates[begin]) return r;
    	if(len - begin == 1) {
    		if(target == candidates[begin]) {
    			ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(candidates[begin]));
    			r.add(e);
    		} else if(target > candidates[begin] && target % candidates[begin] == 0) {
    			ArrayList<Integer> e = new ArrayList<Integer>();
    			int count = target / candidates[begin];
    			for(int i = 0; i < count; i++) {
    				e.add(candidates[begin]);
    			}
    			r.add(e);
    		}
    		return r;
    	}
        if(candidates[begin] == target) {
        	ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(candidates[begin]));
    		r.add(e);
    		return r;
        }
        List<List<Integer>> subr1 = combinationSum(candidates, begin, len, target - candidates[begin]); // contains candidates[begin]
        List<List<Integer>> subr2 = combinationSum(candidates, begin + 1, len, target); // not contains candidates[begin]
        for(List<Integer> L : subr1) {
        	List<Integer> e = L;
        	e.add(0, candidates[begin]);
        	r.add(e);
        }
        for(List<Integer> L : subr2) {
        	r.add(L);
        }
        
        return r;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	int len = candidates.length;
    	if(len == 0) return new ArrayList<List<Integer>>();
        quickSort(candidates, 0, len - 1);
        return combinationSum(candidates, 0, len, target);
    }
}