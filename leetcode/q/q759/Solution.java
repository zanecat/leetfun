package q.q759;

import java.util.*;

class Solution {
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        LinkedList<Interval> queue = new LinkedList<>();

        for (List<Interval> intervals: schedule){
            queue.addAll(intervals);
        }

        queue.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> res = new LinkedList<>();

        if (queue.isEmpty()) return res;

        int end = queue.poll().end;
        while (!queue.isEmpty()){
            Interval cur = queue.poll();
            if (cur.start<= end){
                end = Math.max(end, cur.end);
            } else {
                res.add(new Interval(end, cur.start));
                end = cur.end;
            }
        }

        return res;
    }
}
