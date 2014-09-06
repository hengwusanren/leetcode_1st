import java.util.Stack;
import java.lang.StringBuffer;
public class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        char[] chararrA, chararrB;
        if(lenA > lenB) {
            chararrA = a.toCharArray();
            chararrB = new char[lenA];
            for(int i = 0; i < lenA - lenB; i++)
                chararrB[i] = '0';
            for(int i = lenA - lenB; i < lenA; i++)
                chararrB[i] = b.charAt(i - lenA + lenB);
            lenB = lenA;
        }
        else if(lenA < lenB) {
            chararrB = b.toCharArray();
            chararrA = new char[lenB];
            for(int i = 0; i < lenB - lenA; i++)
                chararrA[i] = '0';
            for(int i = lenB - lenA; i < lenB; i++)
                chararrA[i] = a.charAt(i - lenB + lenA);
            lenA = lenB;
        }
        else {
            chararrA = a.toCharArray();
            chararrB = b.toCharArray();
        }
        Stack<Character> C = new Stack<Character>();
        int cursum = 0;
        int jinwei = 0;
        for(int i = lenA - 1; i >= 0; i--) {
            cursum = chararrA[i] - '0' + chararrB[i] - '0' + jinwei;
            jinwei = cursum / 2;
            cursum = cursum % 2;
            C.push((char)(cursum + '0'));
        }
        if(jinwei > 0) C.push((char)(jinwei + '0'));
        StringBuffer r = new StringBuffer("");
        while(!C.empty()) {
            r.append(C.pop());
        }
        return r.toString();
    }
}