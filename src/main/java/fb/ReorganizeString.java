package fb;


import java.util.HashMap;
import java.util.Map;
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
 *
 *     //Arrange  the character by occurrence
 *     //iterate though each character
 *     // create String using each character and deduct the CharacterCount
 *     // Once we have done, check if any character has count left
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character,Integer> characterCount = new HashMap<>();
        for(char c: s.toCharArray()) {
            characterCount.put(c,characterCount.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> characterCount.get(b) - characterCount.get(a));
        maxHeap.addAll(characterCount.keySet());
        StringBuilder result = new StringBuilder();
        while(maxHeap.size()>1) {
            char firstChar = maxHeap.remove();
            char second = maxHeap.remove();
            result.append(firstChar);
            result.append(second);
            characterCount.put(firstChar,characterCount.get(firstChar)-1);
            characterCount.put(second,characterCount.get(second)-1);

            if(characterCount.get(firstChar) > 0) {
                maxHeap.add(firstChar);
            }

            if(characterCount.get(second) > 0) {
                maxHeap.add(second);
            }

        }
        if(!maxHeap.isEmpty()) {
            char lastChar = maxHeap.remove();
            if(characterCount.get(lastChar) > 0 ){
                return "";
            }
            result.append(lastChar);
        }
        return result.toString();
    }
}
