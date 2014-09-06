public class Solution {
    public String num2letters(int d) {
        switch(d) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
        }
        return "";
    }
    public ArrayList<String> letterCombinations(String digits) {
        int d;
        char[] chararr;
        ArrayList<String> R = new ArrayList<String>();
        ArrayList<String> Before = new ArrayList<String>();
        if(digits.equals("")) {
            R.add("");
            return R;
        }
        if(digits.length() == 1) {
            d = digits.charAt(0) - '0';
            chararr = num2letters(d).toCharArray();
            Before.add("");
            for(char c : chararr) {
                for(String s : Before) {
                    R.add(Character.toString(c) + s);
                }
            }
            return R;
        }
        d = digits.charAt(0) - '0';
        chararr = num2letters(d).toCharArray();
        Before = letterCombinations(digits.substring(1));
        for(char c : chararr) {
            for(String s : Before) {
                R.add(Character.toString(c) + s);
            }
        }
        return R;
    }
}