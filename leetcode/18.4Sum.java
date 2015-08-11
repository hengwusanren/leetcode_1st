public class Solution {
    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;
        //以中间元素为基准
        int middle = arr[(left + right + 1) / 2];
        int i = left - 1, j = right + 1;
        while(true)
        {
            while(arr[++i] < middle && i < right) ;
            while(arr[--j] > middle && j > left) ;
            if (i >= j)
                break;
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        quickSort(arr, left, i - 1);
        quickSort(arr, j + 1, right);
    }
    public static String fourNumsToString(int[] fournums) {
        return Integer.toString(fournums[0]) + "," + Integer.toString(fournums[1]) + "," + Integer.toString(fournums[2]) + "," + Integer.toString(fournums[3]);
    }
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        int len = num.length;
        if(len < 4) return r;
        HashMap<Integer, HashSet<Integer>> hist = new HashMap<Integer, HashSet<Integer>>();
        HashSet<String> solutionHist = new HashSet<String>();
        
        quickSort(num, 0, len - 1);
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                int v = num[i] + num[j];
                if(hist.containsKey(target - v)) {
                    HashSet<Integer> otherpairs = hist.get(target - v);
                    for(int e : otherpairs) {
                        int n_1 = e / len;
                        int n_2 = e % len;
                        if(n_1 == i || n_2 == i || n_1 == j || n_2 == j) continue;
                        int[] tmp4nums = {num[n_1], num[n_2], num[i], num[j]};
                        quickSort(tmp4nums, 0, 3);
                        String combin = fourNumsToString(tmp4nums);
                        if(solutionHist.contains(combin)) continue;
                        solutionHist.add(combin);
                        ArrayList<Integer> curSolution = new ArrayList<Integer>();
                        curSolution.add(tmp4nums[0]);
                        curSolution.add(tmp4nums[1]);
                        curSolution.add(tmp4nums[2]);
                        curSolution.add(tmp4nums[3]);
                        r.add(curSolution);
                    }
                }
                HashSet<Integer> tmpv;
                if(hist.containsKey(v)) tmpv = hist.get(v);
                else tmpv = new HashSet<Integer>();
                tmpv.add(i * len + j);
                hist.put(v, tmpv);
            }
        }
        
        return r;
    }
}