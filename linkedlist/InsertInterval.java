/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        // add the new interval to the list and use previous to solve this
        intervals.add(newInterval);

        // sort the intervals
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }});

        // new list of intervals
        List<Interval> newI = new ArrayList<Interval>();

        for (int i=0; i<intervals.size(); ) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            if ((i+1) >= intervals.size()) {    // no more interval
                i++;
            }
            // starting to merge
            for (int j=i+1; j<intervals.size(); j++) {
                int s = intervals.get(j).start;
                int e = intervals.get(j).end;
                // and end
                if (end < s) {  // cannot merge
                    i = j;
                    break;
                }
                else {
                    // update start and end
                    // start = (start < s) ? start : s;    // choose smaller one
                    end = (end > e) ? end : e;  // choose the bigger one
                    i = j+1;
                }
            }
            // save to the new list
            newI.add(new Interval(start, end));
        }
        return newI;
    }
}