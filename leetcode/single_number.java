import java.util.HashSet;
import java.util.Iterator;
public class Solution {
    public int singleNumber(int[] A) {
        HashSet<Integer> s = new HashSet<Integer>();
        for(int i : A){
            if(s.contains(i)) s.remove(i);
            else s.add(i);
        }
        return (int)(s.iterator().next());
    }
}