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
    public static List<List<Integer>> combinationSum2(int[] num, int begin, int len, int target) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
    	if(len == 0 || begin == len || target <= 0) return r;
        if(target < num[begin]) return r;
        if(target == num[begin]) {
        	ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(num[begin]));
    		r.add(e);
    		return r;
        }
        List<List<Integer>> subr1 = combinationSum2(num, begin + 1, len, target - num[begin]); // contains num[begin]
        List<List<Integer>> subr2 = combinationSum2(num, begin + 1, len, target); // not contains num[begin]
        for(List<Integer> L : subr1) {
        	List<Integer> e = L;
        	e.add(0, num[begin]);
        	if(!r.contains(e)) r.add(e);
        }
        for(List<Integer> L : subr2) {
        	if(!r.contains(L)) r.add(L);
        }
        
        return r;
    }
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        int len = num.length;
        if(len == 0) return new ArrayList<List<Integer>>();
        quickSort(num, 0, len - 1);
        return combinationSum2(num, 0, len, target);
    }
}