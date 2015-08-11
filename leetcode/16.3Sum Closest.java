public class Solution {
    public static int abs(int a, int b) {
        return a > b ? (a - b) : (b - a);
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
    public static int findThird(int[] arr, int begin, int end, int target) {
        if(arr[begin] >= target) return arr[begin];
        if(arr[end] <= target) return arr[end];
        if(begin == end) return arr[end];
        if(begin == end - 1) return abs(arr[begin], target) > abs(arr[end], target) ? arr[end] : arr[begin];
        int mid = (begin + end) / 2;
        if(arr[mid] > target) {
            return findThird(arr, begin, mid, target);
        }
        return findThird(arr, mid, end, target);
    }
    public int threeSumClosest(int[] num, int target) {
        int len = num.length;
        if(len == 0) return 0;
        if(len == 1) return num[0];
        if(len == 2) return num[0] + num[1];

        quickSort(num, 0, len - 1);
        int closest = num[0] + num[1] + num[2];
        
        for(int i = 0; i < len - 2; i++) {
            for(int j = i + 1; j < len - 1; j++) {
                int v = findThird(num, j + 1, len - 1, target - num[i] - num[j]);
                int dura = abs(num[i] + num[j] + v, target);
                if(dura > abs(closest, target)) continue;
                closest = num[i] + num[j] + v;
            }
        }

        return closest;
    }
}