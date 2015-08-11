public class Solution {
    public String minWindow(String S, String T) {
        int tlen = T.length();
        int slen = S.length();
        if(tlen == 0 || slen == 0) return "";
        HashMap<Character, Integer> c = new HashMap<Character, Integer>();
        for(int i = 0; i < tlen; i++) {
            if(c.containsKey(T.charAt(i))) c.put(T.charAt(i), c.get(T.charAt(i)) + 1);
            else c.put(T.charAt(i), 1);
        }
        
        if(tlen == 1) return (S.indexOf(T.charAt(0)) == -1) ? "" : Character.toString(T.charAt(0));
        if(tlen > slen) return "";
        
        int beginpos = 0, curbeginpos = 0, endpos = 0, curendpos = 0;
        HashMap<Character, Integer> hist = new HashMap<Character, Integer>();
        int histSize = 0;
        boolean hassolution = false;
        for(int i = 0; i < slen; i++) {
            if(!c.containsKey(S.charAt(i))) {
                continue;
            }
            if(hist.containsKey(S.charAt(i))) {
                hist.put(S.charAt(i), hist.get(S.charAt(i)) + 1);
                if(hist.get(S.charAt(i)) > c.get(S.charAt(i))) continue;
            }
            else {
                hist.put(S.charAt(i), 1);
            }
            histSize++;
            endpos = i;
            if(histSize == tlen) {
                hassolution = true;
                while(beginpos < endpos) {
                    if(!c.containsKey(S.charAt(beginpos))) beginpos++;
                    else if(hist.get(S.charAt(beginpos)) > c.get(S.charAt(beginpos))) {
                        hist.put(S.charAt(beginpos), hist.get(S.charAt(beginpos)) - 1);
                        beginpos++;
                    }
                    else break;
                }
                if(curendpos - curbeginpos > endpos - beginpos || curendpos - curbeginpos + 1 < tlen) {
                    curendpos = endpos;
                    curbeginpos = beginpos;
                }
                if(hist.get(S.charAt(beginpos)) == 1) hist.remove(S.charAt(beginpos));
                else hist.put(S.charAt(beginpos), hist.get(S.charAt(beginpos)) - 1);
                histSize--;
                beginpos++;
                while(beginpos < endpos) {
                    if(!c.containsKey(S.charAt(beginpos))) beginpos++;
                    else if(hist.get(S.charAt(beginpos)) > c.get(S.charAt(beginpos))) {
                        hist.put(S.charAt(beginpos), hist.get(S.charAt(beginpos)) - 1);
                        beginpos++;
                    }
                    else break;
                }
            }
        }
        if(!hassolution) return "";
        return S.substring(curbeginpos, curendpos + 1);
    }
}