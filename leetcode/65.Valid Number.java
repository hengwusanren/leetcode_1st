public class Solution {
    public boolean isBasicNumber(String s, boolean allowDot) {
        String snew0 = s.trim();
        if(snew0.equals("") || snew0.indexOf(' ') >= 0)
            return false;
        String snew;
        if(snew0.charAt(0) == '+' || snew0.charAt(0) == '-')
            snew = snew0.substring(1).trim();
        else
            snew = snew0;
        if(snew.equals(""))
            return false;
        int dotCount = 0;
        char[] carr = snew.toCharArray();
        
        if(allowDot) {
            for(char c : carr) {
                if((c < '0' || c > '9') && c != '.')
                    return false;
                if(c == '.') {
                    dotCount++;
                    if(dotCount > 1)
                        return false;
                    continue;
                }
            }
        }
        else {
            for(char c : carr)
                if(c < '0' || c > '9')
                    return false;
        }
        
        if(snew.length() == 1 && dotCount > 0)
            return false;
        return true;
    }
    public boolean isNumber(String s) {
        String snew = s.trim();
        if(snew.indexOf(' ') > 0)
            return false;
        if(snew.indexOf('e') < 0)
            return isBasicNumber(snew, true);
        if(snew.indexOf('e') != snew.lastIndexOf('e'))
            return false;
        String[] strs = s.split("e");
        ArrayList<String> sarr = new ArrayList<String>();
        for(String i : strs) {
            if(i.trim().equals(""))
                continue;
            sarr.add(i.trim());
        }
        if(sarr.size() != 2)
            return false;
        return isBasicNumber(sarr.get(0), true) && isBasicNumber(sarr.get(1), false);
    }
}