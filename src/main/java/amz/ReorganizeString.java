package amz;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * Example 1:
 *
 * Input: S = "aab"
 * Output: "aba"
 *
 * Example 2:
 *
 * Input: S = "aaab"
 * Output: ""
 *
 * Note:
 *
 *     S will consist of lowercase letters and have length in range [1, 500].
 */
public class ReorganizeString {
    public static String reorganizeString(String s) {
        if(s == null || s.length()-1<2) return s;
        HashMap<Character,Integer> charactorCount = new HashMap<>();
        for(char c: s.toCharArray()) {
            charactorCount.put(c, charactorCount.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> max_heap = new PriorityQueue<>((a, b) -> charactorCount.get(b) - charactorCount.get(a));
        max_heap.addAll(charactorCount.keySet());
        StringBuilder result = new StringBuilder();
        while(max_heap.size()>1){
            char firstChar = max_heap.remove();
            char nextChar = max_heap.remove();
            result.append(firstChar);
            result.append(nextChar);
            charactorCount.put(firstChar,charactorCount.get(firstChar) -1);
            charactorCount.put(nextChar,charactorCount.get(nextChar) -1);

            if(charactorCount.get(firstChar)>0){
                max_heap.add(firstChar);
            }

            if(charactorCount.get(nextChar)>0){
                max_heap.add(nextChar);
            }
        }

        if(!max_heap.isEmpty()) {
            char last =  max_heap.remove();
            if(charactorCount.get(last) >1) {
                return "";
            } else {
                result.append(last);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
}
