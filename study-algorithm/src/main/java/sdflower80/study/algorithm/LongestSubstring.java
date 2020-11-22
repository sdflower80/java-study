package sdflower80.study.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sdflower
 * @since 24/06/2020 14:36
 */
public class LongestSubstring {

    public static void main(String[] args) {
        /*int pwwkew = new LongestSubstring().lengthOfLongestSubstring("pwwk");
        System.out.println(pwwkew);*/

        System.out.println(new LongestSubstring().resolve2("pwwkew"));
    }

    public int resolve1(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    // pww
    public int resolve2(String s) {
        int start = 0;
        int longestLen = 0;
        Set<String> index = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            String one = String.valueOf(s.charAt(i));
            if (index.contains(one)) {
                int curLen = s.substring(start, i).length();
                longestLen = Math.max(longestLen, curLen);
                start = i;
            } else {
                index.add(one);
            }
        }
        return longestLen;
    }
}
