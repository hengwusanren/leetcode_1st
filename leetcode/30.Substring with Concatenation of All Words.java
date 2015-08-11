public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        int slen = S.length();
        int n = L.length;
        ArrayList<Integer> re = new ArrayList<Integer>();
        if(n == 0) return re;
        int llen = L[0].length();
        if(slen < llen) return re;
        int m = slen - llen + 1;
        String[] index = new String[m];
        HashMap<String, Integer> table = new HashMap<String, Integer>();
    	for(int i = 0; i < n; i++) {
    		if(!table.containsKey(L[i])) table.put(L[i], 1);
    		else table.put(L[i], table.get(L[i]) + 1);
    	}
    	for(int i = 0; i < m; i++) {
    		index[i] = S.substring(i, i + llen);
    	}
    	for(int i = 0; i < llen; i++) {
    		HashMap<String, Integer> tmptable = new HashMap(table);
    		int beginpos = i, endpos = i;
    		boolean ifbegin = true;
    		for(int j = i; j < m; j += llen) {
    			if(!tmptable.containsKey(index[j])) {
    			    if(!table.containsKey(index[j])) {
        				ifbegin = false;
        				tmptable = new HashMap(table);
        				continue;
    			    }
    			    while(!tmptable.containsKey(index[j]) && beginpos < j) {
    			        if(!tmptable.containsKey(index[beginpos])) tmptable.put(index[beginpos], 1);
    			        else tmptable.put(index[beginpos], tmptable.get(index[beginpos]) + 1);
    			        beginpos += llen;
    			    }
    			    if(!tmptable.containsKey(index[j])) {
    			        ifbegin = false;
        				tmptable = new HashMap(table);
        				continue;
    			    }
    			}
    			int tmpcount = tmptable.get(index[j]);
    			if(tmpcount == 1) tmptable.remove(index[j]);
    			else tmptable.put(index[j], tmpcount - 1);
    			if(!ifbegin) {
    				beginpos = j;
    				ifbegin = true;
    			}
    			endpos = j;
    			if(tmptable.isEmpty()) {
    				re.add(beginpos);
    				tmptable.put(index[beginpos], 1);
    				beginpos += llen;
    			}
    		}
    	}
    	return re;
    }
}