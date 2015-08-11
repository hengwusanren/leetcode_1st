public class Solution {
	public static String shrink(String num) {
        int len = num.length();
        int i = 0;
        for(; i < len; i++) {
            if(num.charAt(i) != '0') break;
        }
        if(i == len) return "0";
        return num.substring(i);
    }
	public static String leftShift(String num, int bits) {
        String nnum = shrink(num);
        if(nnum.equals("0")) return "0";
		StringBuffer r = new StringBuffer(nnum);
		while(bits > 0) {
			r.append("0");
			bits--;
		}
		return r.toString();
	}
	public static int intOf(char c) { return c - '0'; }
	public static char charOf(int i) { return (char)(i + '0'); }
	public static String addStrings(String n1, String n2) {
        String num1 = shrink(n1);
        String num2 = shrink(n2);
		int len1 = num1.length();
		int len2 = num2.length();
		if(len1 == 0 || len2 == 0) {
			if(len1 == 0 && len2 == 0) return "0";
			if(len1 == 0) return num1;
			return num2;
		}
		if(len1 > len2) return addStrings(num2, num1);
		StringBuffer result = new StringBuffer("");
		int jinwei = 0;
		for(int i = 0; i < len1; i++) {
			int s = intOf(num1.charAt(len1 - 1 - i)) + intOf(num2.charAt(len2 - 1 - i)) + jinwei;
			int r = s % 10;
			jinwei = s / 10;
			result.insert(0, charOf(r));
		}
		for(int i = len2 - len1 - 1; i >= 0; i--) {
			int s = intOf(num2.charAt(i)) + jinwei;
			int r = s % 10;
			jinwei = s / 10;
			result.insert(0, charOf(r));
		}
        if(jinwei == 1)
            result.insert(0, '1');

		return shrink(result.toString());
	}
    public static String multiply(String num1, String num2, int leftOffset) {
        String nnum1 = shrink(num1);
        String nnum2 = shrink(num2);
        int len1 = nnum1.length();
        int len2 = nnum2.length();
		if(len1 <= 4 && len2 <= 4) {
			int n1 = Integer.parseInt(nnum1);
			int n2 = Integer.parseInt(nnum2);
			return shrink(leftShift(Integer.toString(n1 * n2), leftOffset));
		}
		if(len1 > 4) {
			int leftpartlen  = len1 / 2;
			int rightpartlen = len1 - leftpartlen;
			String leftpart  = nnum1.substring(0, leftpartlen);
			String rightpart = nnum1.substring(leftpartlen);
			return addStrings(multiply(leftpart, nnum2, leftOffset + rightpartlen), multiply(rightpart, nnum2, leftOffset));
		}
		return multiply(nnum2, nnum1, leftOffset);
    }
    public static String multiply(String num1, String num2) {
        return multiply(num1, num2, 0);
    }
}