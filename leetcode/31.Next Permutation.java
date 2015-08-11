/*
设P是[1,n]的一个全排列
    P=P1P2…Pn=P1P2…Pj-1PjPj+1…Pk-1PkPk+1…Pn
    find:   j=max{i|Pi<Pi+1}
            k=max{i|Pi>Pj}
    1. 对换Pj, Pk，
    2. 将Pj+1…Pk-1PjPk+1…Pn翻转
    P' = P1P2…Pj-1PkPn…Pk+1PjPk-1…Pj+1即P的下一个
*/

public class Solution {
    public static void swap(int[] num, int p, int q) {
        int t = num[p];
        num[p] = num[q];
        num[q] = t;
    }
    public static void reverse(int[] num, int begin, int end) {
        for(int i = begin, j = end; i < j; i++, j--) {
            swap(num, i, j);
        }
    }
    public void nextPermutation(int[] num) {
        int len = num.length;
        if(len <= 1) return;
        int j = len - 2;
        for(; j >= 0; j--) {
            if(num[j] < num[j + 1]) break;
        }
        if(j == -1) {
            reverse(num, 0, len - 1);
            return;
        }
        int k = len - 1;
        for(; k >= 0; k--) {
            if(num[k] > num[j]) break;
        }
        swap(num, j, k);
        reverse(num, j + 1, len - 1);
    }
}