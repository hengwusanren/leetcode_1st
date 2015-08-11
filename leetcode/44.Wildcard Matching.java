public class Solution {
    public static int findMatch(String olds, int begin, String p) {
    	String s = olds.substring(begin);
    	int slen = s.length();
    	int plen = p.length();
    	if(slen == 0) {
    		return -1;
    	}
    	if(slen == 1) {
    		if(plen != 1) return -1;
    		if(p.equals("?") || p.equals(s)) return begin + 1;
    		return -1;
    	}
    	int i, j;
    	for(i = 0; i <= slen - plen; i++) {
    		for(j = 0; j < plen; j++) {
    			if(s.charAt(i + j) != p.charAt(j) && p.charAt(j) != '?') break;
    		}
    		if(j == plen) return begin + i + j;
    	}
    	return -1;
    }
    public static int findLastMatch(String olds, int begin, String p) {
    	String s = olds.substring(begin);
    	int slen = s.length();
    	int plen = p.length();
    	if(slen == 0) {
    		return -1;
    	}
    	if(slen == 1) {
    		if(plen != 1) return -1;
    		if(p.equals("?") || p.equals(s)) return begin + 1;
    		return -1;
    	}
    	int i, j;
    	for(i = 0; i <= slen - plen; i++) {
    		for(j = 0; j < plen; j++) {
    			if(s.charAt(slen - 1 - i - j) != p.charAt(plen - 1 - j) && p.charAt(plen - 1 - j) != '?') break;
    		}
    		if(j == plen) return begin + slen - i;
    	}
    	return -1;
    }
    public static boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        if(plen == 0) return slen == 0;
        StringBuffer np = new StringBuffer("");
        np.append(p.charAt(0));
        for(int i = 1; i < p.length(); i++) {
            if(p.charAt(i) == '*' && p.charAt(i - 1) == '*') continue;
            np.append(p.charAt(i));
        }
        String newp = np.toString();
        plen = newp.length();
        
        int spos = 0;
        int ppos = 0;
        
        while(spos <= slen && ppos < plen) {
        	if(newp.charAt(ppos) == '*') {
        		ppos++;
        		if(ppos == plen) return true;
        		continue;
        	}
        	int nextstar = newp.indexOf('*', ppos);
        	if(nextstar == -1) nextstar = plen;
        	String tmp = newp.substring(ppos, nextstar);
        	int nextmatch = ((nextstar == plen && ppos != 0) ? findLastMatch(s, spos, tmp) : findMatch(s, spos, tmp));
        	if(ppos == 0 && nextmatch != spos + nextstar - ppos) return false;
        	if(nextmatch < 0) return false;
        	if(nextmatch == slen && nextstar == plen) return true;
        	spos = nextmatch;
        	ppos = nextstar;
        }
        
        return false;
    }
}