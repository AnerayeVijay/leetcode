package fb;

import fb.helper.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 919. Meeting Rooms II
 * 中文
 * English
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * Example
 *
 * Example1
 *
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: 2
 * Explanation:
 * We need two meeting rooms
 * room1: (0,30)
 * room2: (5,10),(15,20)
 *
 * Example2
 *
 * Input: intervals = [(2,7)]
 * Output: 1
 * Explanation:
 * Only need one meeting room
 */
public class MeetingRoo_II {


    public static int minMeetingRooms(List<Interval> intervals) {
        //Sorting the interval list based on meeting start time.
        Collections.sort(intervals, (Interval x, Interval y) ->
                 x.start - y.start

        );
        List<Integer> rooms = new ArrayList<Integer>();
        boolean flag = false;
        for(Interval x: intervals){
            //for each meeting check all the rooms. if any room is avaiable then update the meeting end time in that room.
            for(int i=0;i<rooms.size();i++){
                if(x.start>rooms.get(i)){
                 //   rooms.set(i,x.end);
                    flag = true;
                    break;
                }
            }
            // rooms were not available then add a new room.
            if(!flag){
                rooms.add(x.end);
            }
            flag = false;
        }

        return rooms.size();
    }

    public static int minMeetingRooms1(List<Interval> intervals) {
        if (intervals == null) return 0;
        Collections.sort(intervals, ((a, b) -> a.start - b.start));
        Interval firstInterval = intervals.get(0);
        int count=0;
        for (int i=1;i<intervals.size();i++) {
           Interval nextInterVal = intervals.get(i);
           if(firstInterval.end>nextInterVal.start) {
               count++;

           } else {
               firstInterval = nextInterVal;
           }
        }
        return count;
        // Write your code here
    }

    public static void main(String[] args) {
        //(0,30),(5,10),(15,20
        //
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,30));
        intervals.add(new Interval(5,10));
        intervals.add(new Interval(15,20));
        System.out.println(minMeetingRooms(intervals));
    }
}
