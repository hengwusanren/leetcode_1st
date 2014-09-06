/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public class RLNFlag {
        int label;
        int randomIndex;
        public RLNFlag(int x) { this.label = x; }
        public int getLabel() { return this.label; }
        public int getRI() { return this.randomIndex; }
        public void setRI(int i) { this.randomIndex = i; }
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        ArrayList<RLNFlag> RL = new ArrayList<RLNFlag>();
        HashMap<RandomListNode, Integer> RLN2Index = new HashMap<RandomListNode, Integer>();
        RandomListNode p = head;
        int n, i = 0;
        while(p != null) {
            RL.add(new RLNFlag(p.label));
            RLN2Index.put(p, i);
            p = p.next;
            i++;
        }
        n = i;
        p = head;
        i = 0;
        while(p != null) {
            RL.get(i).setRI(p.random == null ? -1 : RLN2Index.get(p.random));
            p = p.next;
            i++;
        }
        RandomListNode[] RLNs = new RandomListNode[n];
        for(i = 0; i < n; i++)
            RLNs[i] = new RandomListNode(RL.get(i).getLabel());
        for(i = 0; i < n - 1; i++) {
            RLNs[i].next = RLNs[i + 1];
            RLNs[i].random = RL.get(i).getRI() == -1 ? null : RLNs[RL.get(i).getRI()];
        }
        RLNs[n - 1].next = null;
        RLNs[n - 1].random = RL.get(n - 1).getRI() == -1 ? null : RLNs[RL.get(n - 1).getRI()];
        return RLNs[0];
    }
}