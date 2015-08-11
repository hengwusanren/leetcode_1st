/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        vector<Interval> r;
        vector<Interval>::iterator it;
        int status = 0; // 1: newInterval has started, 2: newInterval has ended.
        int newStart = newInterval.start;
        int newEnd = newInterval.end;
        for(it = intervals.begin(); it != intervals.end(); it++) {
            if(status == 0) {
                if(newInterval.end < (*it).start) {
                    r.push_back(newInterval);
                    r.push_back(*it);
                    status = 2;
                    continue;
                }
                if(newInterval.start <= (*it).start) {
                    newStart = newInterval.start;
                    if(newInterval.end <= (*it).end) {
                        newEnd = (*it).end;
                        r.push_back(Interval(newStart, newEnd));
                        status = 2;
                        continue;
                    }
                    status = 1;
                    continue;
                }
                if(newInterval.start <= (*it).end) {
                    newStart = (*it).start;
                    if(newInterval.end <= (*it).end) {
                        r.push_back(*it);
                        status = 2;
                        continue;
                    }
                    status = 1;
                    continue;
                }
                r.push_back(*it);
                status = 0;
                continue;
            } else if(status == 1) {
                if(newInterval.end < (*it).start) {
                    newEnd = newInterval.end;
                    r.push_back(Interval(newStart, newEnd));
                    r.push_back(*it);
                    status = 2;
                    continue;
                }
                if(newInterval.end <= (*it).end) {
                    newEnd = (*it).end;
                    r.push_back(Interval(newStart, newEnd));
                    status = 2;
                    continue;
                }
                continue;
            } else {
                r.push_back(*it);
            }
        }
        if(status == 0) r.push_back(newInterval);
        else if(status == 1) r.push_back(Interval(newStart, newEnd));
        
        return r;
    }
};