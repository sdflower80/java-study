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
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            k = Math.max(index[s.charAt(i)], k);
            System.out.printf("s=%s, index=%d, k=%d, kc=%s\n", s.charAt(i), index[s.charAt(i)], k, s.charAt(k));
            ans = Math.max(ans, i - k + 1);
            index[s.charAt(i)] = i + 1;
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
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            max = Math.max(max, i - start);
            start = Math.max(start, index.getOrDefault(c, 0) + 1);
            index.put(c, i);
            System.out.printf("c=%s, start=%d \n", c, start);
        }
        return max;
    }
}
