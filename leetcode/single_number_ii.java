import java.util.HashMap;
public class Solution {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> num2count = new HashMap<Integer, Integer>();
        for(int i : A) {
            num2count.put(i, num2count.containsKey(i) ? num2count.get(i) + 1 : 1);
        }
        for(int k : num2count.keySet()) {
            if(num2count.get(k) != 3)
                return k;
        }
        return 0;
    }
}