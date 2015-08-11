public class Solution {
    public static int twoNumsHash(int a, int b, int jinzhi) {
        //return (long)(a) * (long)(jinzhi) + (long)(b);
        return (a * jinzhi + b);
    }
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
    public static void sortThreeNums(int[] threenums) {
        int a = threenums[0];
        int b = threenums[1];
        int c = threenums[2];
        if(a < b) {
            if(b < c) {
                return;
            }
            threenums[2] = b;
            if(a < c) {
                threenums[0] = a;
                threenums[1] = c;
            } else {
                threenums[0] = c;
                threenums[1] = a;
            }
        } else {
            if(b > c) {
                threenums[2] = a;
                threenums[0] = c;
                threenums[1] = b;
                return;
            }
            threenums[0] = b;
            if(a < c) {
                threenums[1] = a;
                threenums[2] = c;
            } else {
                threenums[1] = c;
                threenums[2] = a;
            }
        }
    }
    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        int len = num.length;
        if(len < 3) return r;

        quickSort(num, 0, len - 1);
        HashMap<Integer, HashSet<Integer>> hist = new HashMap<Integer, HashSet<Integer>>();

        HashSet<Integer> idxesofsameval = new HashSet<Integer>();
        idxesofsameval.add(0);
        int curval = num[0];
        for(int i = 1; i < len; i++) {
            if(num[i] == curval) {
                idxesofsameval.add(i);
            } else {
                hist.put(curval, idxesofsameval);
                curval = num[i];
                idxesofsameval = new HashSet<Integer>();
                idxesofsameval.add(i);
            }
        }
        hist.put(curval, idxesofsameval);

        HashSet<Integer> solutionHist = new HashSet<Integer>();

        ArrayList<Integer> curSolution;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                int v = num[i] + num[j];
                if(-v < num[j] || !hist.containsKey(-v)) continue;
                int[] tmp3nums = {-v, num[i], num[j]};
                sortThreeNums(tmp3nums);
                int combin = twoNumsHash(tmp3nums[0], tmp3nums[1], len);
                if(solutionHist.contains(combin)) continue;

                if(num[i] != -v && num[j] != -v) {
                    curSolution = new ArrayList<Integer>(Arrays.asList(tmp3nums[0], tmp3nums[1], tmp3nums[2]));
                    r.add(curSolution);
                    solutionHist.add(combin);
                    continue;
                }
                HashSet<Integer> anothers = hist.get(-v);
                for(int e : anothers) {
                    if(e == i || e == j) continue;
                    curSolution = new ArrayList<Integer>(Arrays.asList(tmp3nums[0], tmp3nums[1], tmp3nums[2]));
                    r.add(curSolution);
                    solutionHist.add(combin);
                    break;
                }
            }
        }

        return r;
    }
}