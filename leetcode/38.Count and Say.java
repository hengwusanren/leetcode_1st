public class Solution {
    public static StringBuffer cs(StringBuffer s) {
        StringBuffer re = new StringBuffer("");
        
        int len = s.length();
        if(len == 0) return s;
        char curNum = s.charAt(0);
        int curNumCount = 1;
        for(int i = 1; i < len; i++) {
            if(s.charAt(i) != curNum) {
                re.append(Integer.toString(curNumCount) + Character.toString(curNum));
                curNum = s.charAt(i);
                curNumCount = 1;
            } else {
                curNumCount++;
            }
        }
        re.append(Integer.toString(curNumCount) + Character.toString(curNum));
        
        return re;
    }
    public String countAndSay(int n) {
        StringBuffer s = new StringBuffer(Integer.toString(1));
        //System.out.println(s);
        for(int i = 1; i < n; i++) {
            s = cs(s);
            //System.out.println(s);
        }
        return s.toString();
    }
}