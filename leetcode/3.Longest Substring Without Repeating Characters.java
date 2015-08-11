public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> rec = new HashMap<Character, Integer>();
        int len = s.length();
        int tmp_len = 0;
        int tmp_begin = 0;
        int tmp_end = 0;
        for(int i = 0; i < len; i++) {
        	tmp_end = i;
        	if(!rec.containsKey(s.charAt(i))) {
        		int new_len = tmp_end - tmp_begin + 1;
        		tmp_len = tmp_len > new_len ? tmp_len : new_len;
        		rec.put(s.charAt(i), i);
        		continue;
        	}
        	int old_begin = tmp_begin;
        	tmp_begin = rec.get(s.charAt(i)) + 1;
        	for(int j = old_begin; j < tmp_begin - 1; j++) {
        	    rec.remove(s.charAt(j));
        	}
        	rec.put(s.charAt(i), i);
        }
        return tmp_len;
    }
}