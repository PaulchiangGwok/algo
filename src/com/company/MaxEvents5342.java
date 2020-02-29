package com.company;


import java.lang.reflect.Method;
import java.util.*;

public class MaxEvents5342 {

    public static void main(String[] args) {
        //int[][] x = {{6, 6}, {3, 4}, {22, 26}, {29, 32}, {8, 10}, {8, 9}, {30, 30}, {19, 21}, {30, 34}, {20, 20},
        //    {29, 32}, {4, 5}, {16, 17}, {3, 3}, {14, 16}, {9, 10}, {2, 5}, {7, 11}, {3, 3}, {18, 20}, {26, 28},
        //    {15, 19}, {26, 27}, {22, 22}, {2, 3}, {16, 20}, {2, 3}, {23, 27}, {25, 28}, {17, 20}};

        int[][] x= {{1,4},{4,4},{2,2},{3,4},{1,1}};
        System.out.println(maxEvents(x));
    }

    public static int maxEvents(int[][] events) {
        PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            } else {
                return o1.start - o2.start;
            }
        });

        for (int[] event : events) {
            pq.offer(new Meeting(event[0], event[1]));
        }

        int cur = pq.peek().start;
        int res= 0;
        while (!pq.isEmpty()) {
            Meeting meeting = pq.poll();
            //过期
            if (meeting.end < cur) {
                continue;
            }


            if (meeting.start < cur) {
                pq.offer(new Meeting(cur,meeting.end));
            } else {
                cur = Integer.max(cur + 1, meeting.start + 1);
                res ++;
            }

        }
        return res;
    }

    static class Meeting {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
