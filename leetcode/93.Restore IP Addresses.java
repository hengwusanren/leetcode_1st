public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return subAddrs(s, 3);
    }
    public List<String> subAddrs(String s, int dotCount) {
        int len = s.length();
        List<String> r = new ArrayList<String>();
        if(len - 1 < dotCount) return r;
        if(len - 1 == dotCount) {
            char[] chararr = s.toCharArray();
            StringBuffer sb = new StringBuffer("");
            int i = 0;
            for(; i < len - 1; i++) {
                sb.append(chararr[i]);
                sb.append('.');
            }
            sb.append(chararr[i]);
            r.add(sb.toString());
            return r;
        }
        if(dotCount == 0) {
            if(s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0'))
                return r;
            int i = Integer.parseInt(s);
            if(i <= 255) {
                r.add(s);
            }
            return r;
        }
        int maxfirstend = len - dotCount;
        if(maxfirstend < 1) return r;
        String s0 = s.substring(0, 1);
        List<String> sub0 = subAddrs(s.substring(1, len), dotCount - 1);
        if(sub0.size() > 0) {
            for(String e : sub0) {
                r.add(s0 + "." + e);
            }
        }
        if(s.charAt(0) == '0') return r;
        if(maxfirstend >= 2) {
            String s1 = s.substring(0, 2);
            List<String> sub1 = subAddrs(s.substring(2, len), dotCount - 1);
            if(sub1.size() > 0) {
                for(String e : sub1) {
                    r.add(s1 + "." + e);
                }
            }
        }
        if(maxfirstend >= 3) {
            String s2 = s.substring(0, 3);
            int i2 = Integer.parseInt(s2);
            if(i2 <= 255) {
                List<String> sub2 = subAddrs(s.substring(3, len), dotCount - 1);
                if(sub2.size() > 0) {
                    for(String e : sub2) {
                        r.add(s2 + "." + e);
                    }
                }
            }
        }
        
        return r;
    }
}