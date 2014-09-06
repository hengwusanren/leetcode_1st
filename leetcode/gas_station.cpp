/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
*/
class Solution {
public:
	int nextStation(int i, int n, bool inc) {
		if(inc) {
			if(i == n - 1)
				return 0;
			return i + 1;
		}
		if(i == 0)
			return n - 1;
		return i - 1;
	}
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
        int n = gas.size();
		
		int *p = new int[n];
        for (int i = 0; i < n; i++) {
			p[i] = 0;
			bool ifBreak = false;
			int j = nextStation(i, n, true);
			for (; j != i; j = nextStation(j, n, true)) {
				int preSta = nextStation(j, n, false);
				p[j] = p[preSta] + gas[preSta] - cost[preSta];
				if(p[j] < 0) {
					ifBreak = true;
					break;
				}
			}
			if(ifBreak) {
				continue;
			}
			j = nextStation(i, n, false);
			p[i] = p[j] + gas[j] - cost[j];
			if(p[i] >= 0)
				return i;
		}
		for (int i = 0; i < n; i++) {
			p[i] = 0;
			bool ifBreak = false;
			int j = nextStation(i, n, false);
			for (; j != i; j = nextStation(j, n, false)) {
				int preSta = nextStation(j, n, true);
				p[j] = p[preSta] + gas[preSta] - cost[j];//
				if(p[j] < 0) {
					ifBreak = true;
					break;
				}
			}
			if(ifBreak) {
				continue;
			}
			j = nextStation(i, n, true);
			p[i] = p[j] + gas[j] - cost[i];//
			if(p[i] >= 0)
				return i;
		}
        
		// p[a][b]是从a出发到达b时剩下的gas，在顺序1下，有如下递推关系：
		// p[a][a+1] = gas[a] - cost[a]
		// p[a][b] + p[b][c] = p[a][c]
		
		// 顺序1：0, 1, 2, ..., n-1
		// 顺序2：n-1, n-2, n-3, ..., 0

        delete p;
        return -1;
    }
};
