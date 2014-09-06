import java.util.HashMap;
public class Solution {
    public int numDecodings(String str, int begin, HashMap<Integer, Integer> history) {
        int v;
        String s = str.substring(begin);
        switch(s.length()) {
            case 0:
                return 0;
            case 1:
                v = Integer.parseInt(s);
                if(v == 0) return 0;
                return 1;
            case 2:
                v = Integer.parseInt(s);
                if(v <= 9) return 0;
                if(v > 26) {
                    if(v % 10 == 0) return 0;
                    return 1;
                }
                if(v % 10 == 0) return 1;
                return 2;
        }
        if(!history.containsKey(begin + 1))
            history.put(begin + 1, numDecodings(str, begin + 1, history));
        int ss1 = history.get(begin + 1);//2
        int ss2;
        v = (begin + 2 >= str.length()) ? 27 : Integer.parseInt(str.substring(begin, begin + 2));
        if(v <= 26 && v >= 10) {
            if(!history.containsKey(begin + 2))
                history.put(begin + 2, numDecodings(str, begin + 2, history));
            ss2 = history.get(begin + 2);
        }
        else ss2 = 0;
        return numDecodings(str.substring(begin, begin + 1)) * ss1 + ss2;
    }
    public int numDecodings(String s) {
        int v;
        switch(s.length()) {
            case 0:
                return 0;
            case 1:
                v = Integer.parseInt(s);
                if(v == 0) return 0;
                return 1;
            case 2:
                v = Integer.parseInt(s);
                if(v <= 9) return 0;
                if(v > 26) {
                    if(v % 10 == 0) return 0;
                    return 1;
                }
                if(v % 10 == 0) return 1;
                return 2;
        }
        HashMap<Integer, Integer> numDecOfSubStr = new HashMap<Integer, Integer>();
        numDecOfSubStr.put(s.length(), 1);
        return numDecodings(s, 0, numDecOfSubStr);
    }
}