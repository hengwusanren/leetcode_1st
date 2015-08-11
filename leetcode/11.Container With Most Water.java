public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        if(len <= 1) return 0;
        int maxarea = 0;
        ArrayList<Integer> incHeights = new ArrayList<Integer>();
        ArrayList<Integer> incHeightIndexes = new ArrayList<Integer>();
        ArrayList<Integer> decHeights = new ArrayList<Integer>();
        ArrayList<Integer> decHeightIndexes = new ArrayList<Integer>();

        int curHighest = height[0];
        incHeights.add(height[0]);
        incHeightIndexes.add(0);
        for(int i = 1; i < len; i++) {
        	if(height[i] > curHighest) {
        		curHighest = height[i];
        		incHeights.add(height[i]);
        		incHeightIndexes.add(i);
        	}
        }
        curHighest = height[len - 1];
        decHeights.add(height[len - 1]);
        decHeightIndexes.add(len - 1);
        for(int i = len - 2; i >= incHeightIndexes.get(incHeightIndexes.size() - 1); i--) {
        	if(height[i] > curHighest) {
        		curHighest = height[i];
        		decHeights.add(height[i]);
        		decHeightIndexes.add(i);
        	}
        }

        for(int i = 0; i < incHeights.size(); i++) {
        	for(int j = 0; j < decHeights.size(); j++) {
        		if(incHeightIndexes.get(i) < decHeightIndexes.get(j)) {
        			int tmparea = (incHeights.get(i) > decHeights.get(j) ? decHeights.get(j) : incHeights.get(i)) * (decHeightIndexes.get(j) - incHeightIndexes.get(i));
        			if(maxarea < tmparea) maxarea = tmparea;
        		}
        	}
        }

        return maxarea;
    }
}