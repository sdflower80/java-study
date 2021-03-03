package sdflower80.study.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sdflower
 * @since 24/06/2020 14:36
 */
public class LongestSubstring {

    public static void main(String[] args) {
        /*int pwwkew = new LongestSubstring().lengthOfLongestSubstring("pwwk");
        System.out.println(pwwkew);*/
        System.out.println(new LongestSubstring().resolve2("abcazabb"));
    }

    public int resolve1(String s) {
        int ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            left = Math.max(index[s.charAt(right)], left);
            System.out.printf("s=%s, index=%d, k=%d, kc=%s\n", s.charAt(right), index[s.charAt(right)], left, s.charAt(left));
            ans = Math.max(ans, right - left + 1);
            index[s.charAt(right)] = right + 1;
        }
        return ans;
    }

    /**
     * "abcazabb"
     * "pwwkew"
     */
    public int resolve2(String s) {
        Map<Character, Integer> index = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, index.getOrDefault(c, left));
            max = Math.max(max, right - left + 1);
            index.put(c, right + 1);
            System.out.printf("c=%s, left=%d \n", c, left);
        }
        return max;
    }
}
