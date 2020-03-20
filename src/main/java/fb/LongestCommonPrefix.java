package fb;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";

        if(strs == null || strs.length<=0) return longestCommonPrefix;
        int index =0;
        for(char c: strs[0].toCharArray()){
            for(int i=1; i<strs.length;i++){
                if(index>=strs[i].length() || c != strs[i].charAt(index)) {
                    return longestCommonPrefix;
                }
            }
            longestCommonPrefix += c;
            index++;
        }

        return longestCommonPrefix;
    }

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
                //{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
