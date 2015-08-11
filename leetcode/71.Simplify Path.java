public class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        int len = dirs.length;
        ArrayList<String> p = new ArrayList<String>();
        for(int i = 0; i < len; i++) {
        	if(dirs[i].trim().equals("")) continue;
        	else if(dirs[i].trim().equals(".")) continue;
        	else if(dirs[i].trim().equals("..")) {
        		if(p.size() == 0) continue;
        		p.remove(p.size() - 1);
        	}
        	else {
        		p.add(dirs[i]);
        	}
        }
        if(p.size() == 0) p.add("");
        StringBuffer sb = new StringBuffer("");
        for(String s : p) {
        	sb.append("/" + s);
        }
        return sb.toString();
    }
}