import java.lang.StringBuffer;
public class Solution {
    public int leftshift(String divisor, int d) {
        StringBuffer s = new StringBuffer(divisor);
        while(d > 0) {
            s.append('0');
            d--;
        }
        return Integer.parseInt(s.toString());
    }
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return 0;
        if(divisor == 1) return dividend;
        if(dividend == 0 || (dividend < divisor && dividend > 0)) 
            return 0;
        if(dividend == -2147483648)
            return divisor > 0 ? (divide(dividend + divisor, divisor) - 1) : (divide(dividend - divisor, divisor) + 1);
        if(divisor == -2147483648)
            return 0;
        if(dividend < 0 && divisor < 0)
            return divide(-dividend, -divisor);
        if(dividend > 0 && divisor < 0)
            return -divide(dividend, -divisor);
        if(dividend < 0 && divisor > 0)
            return -divide(-dividend, divisor);
        
        String de = Integer.toString(dividend);
        String ds = Integer.toString(divisor);
        int delen = de.length();
        int dslen = ds.length();
        int deBegin = Integer.parseInt(de.substring(0, dslen));
        int offset = delen - dslen;
        if(deBegin < divisor) {
            deBegin = Integer.parseInt(de.substring(0, dslen + 1));
            offset--;
        }
        
        return divide(dividend - leftshift(ds, offset), divisor) + leftshift("1", offset);
    }
}