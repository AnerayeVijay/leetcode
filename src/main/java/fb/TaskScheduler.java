package fb;

import java.util.*;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        //finding the frequency for all tasks
        for (char c : tasks) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(counts.values());
        int cycle = 0;



        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<n+1;i++) {
                if(!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }

            for(int i: temp) {
                if(--i>0) {
                    maxHeap.add(i);
                }
            }

            cycle += maxHeap.isEmpty() ? temp.size() : n +1;
        }

        return cycle;
    }

    public static int leastInterval1(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        //finding the frequency for all tasks
        for (char c : tasks) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        //the counter of max occurance tasks (Ex: A -> 3 and B -> 3 , means counter = 2)
        int counter = 0;

        // the max occurance count (A or B == 3)
         int maxOccuranceCount = Integer.MIN_VALUE;

        //finding the max occurance value
         for(char key : counts.keySet()) {
             if(counts.get(key) > maxOccuranceCount) {
                 maxOccuranceCount = counts.get(key);
             }
         }

        //finding the counter
           for(char key : counts.keySet()) {
            if(counts.get(key) == maxOccuranceCount) {
               counter++;
           }
         }
         return Math.max(tasks.length, (maxOccuranceCount - 1) * (n + 1) + counter);

    }

    public static void main(String[] args) {
        char[] task = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(task,2));
        System.out.println(leastInterval1(task,2));
    }
}
