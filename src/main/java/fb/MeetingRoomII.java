package fb;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of meeting time intervals consisting of
 * start and end times [[s1,e1],[s2,e2],...] find the minimum number of conference rooms required.
 */
public class MeetingRoomII {
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals == null) return  0;
        Arrays.sort(intervals,(array1,array2) -> array1[0] - array2[0]);
        Arrays.sort(intervals, Comparator.comparingInt(meeting -> meeting[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++) {
            if(queue.peek() <=intervals[i][0])
                queue.poll();
            queue.add(intervals[i][1]);

        }
        return  queue.size();
    }


    public static void main(String[] args) {
       int[][] intervals = {{0,30},
               {5,10},
               {15,20}};
       System.out.println(minMeetingRooms(intervals));
    }
}
