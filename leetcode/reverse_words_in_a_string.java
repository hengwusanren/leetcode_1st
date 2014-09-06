public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s{1,}");
        StringBuffer r = new StringBuffer("");
        int len = words.length;
        
        if(len > 0) r.append(words[len - 1]);
        
        for(int i = len - 2; i >= 0; i--)
            if(!words[i].equals("")) r.append(" " + words[i]);
        
        return r.toString();
    }
}