public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<String>();
        if(n == 0) {
            r.add("");
            return r;
        }
        if(n == 1) {
            r.add("()");
            return r;
        }
        r.add("(");
        // '(': 1
        // ')': -1
        List<Integer> pareCount = new ArrayList<Integer>(); // =0: closed, >0: unclosed
        List<Integer> pairCount = new ArrayList<Integer>(); // how many '('
        pareCount.add(1);
        pairCount.add(1);
        boolean toContinue = true;
        while(toContinue) {
            int len = r.size();
            for(int i = len - 1; i >= 0; i--) {
                if(pairCount.get(i) < n || pareCount.get(i) > 0) {
                    String tmpstr = r.get(i);
                    if(pairCount.get(i) == n) {
                        r.set(i, tmpstr + ")");
                        pareCount.set(i, pareCount.get(i) - 1);
                    } else if(pareCount.get(i) > 0) {
                        r.set(i, tmpstr + ")");
                        pareCount.set(i, pareCount.get(i) - 1);
                        r.add(i + 1, tmpstr + "(");
                        pareCount.add(i + 1, pareCount.get(i) + 2);
                        pairCount.add(i + 1, pairCount.get(i) + 1);
                    } else {
                        r.set(i, tmpstr + "(");
                        pareCount.set(i, pareCount.get(i) + 1);
                        pairCount.set(i, pairCount.get(i) + 1);
                    }
                }
            }
            if(r.get(0).length() == 2 * n) toContinue = false;
        }

        return r;
    }
}