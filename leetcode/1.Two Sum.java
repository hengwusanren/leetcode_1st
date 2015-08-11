public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, ArrayList<Integer>> val2index = new HashMap<Integer, ArrayList<Integer>>();
        int len = numbers.length;
        for(int i = 0; i < len; i++) {
            ArrayList<Integer> a = val2index.containsKey(numbers[i]) ? val2index.get(numbers[i]) : new ArrayList<Integer>();
            a.add(i);
            val2index.put(numbers[i], a);
        }
        for(int i = 0; i < len; i++) {
            if(val2index.containsKey(target - numbers[i]) && !(target == 2 * numbers[i] && val2index.get(numbers[i]).size() == 1)) {
                int[] r = new int[2];
                r[0] = i + 1;
                ArrayList<Integer> a = val2index.get(target - numbers[i]);
                r[1] = a.get(a.size() - 1) + 1;
                return r;
            }
        }
        return null;
    }
}