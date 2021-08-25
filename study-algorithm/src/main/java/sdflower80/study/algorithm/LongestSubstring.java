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
        System.out.println(new LongestSubstring().resolve1("abcazabb"));
    }

    public int resolve1(String s) {
        int ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            l = Math.max(index[s.charAt(r)], l);
            System.out.printf("s=%s, index=%d, l=%d, r=%d\n", s.charAt(r), index[s.charAt(r)], l, r);
            ans = Math.max(ans, r - l + 1);
            index[s.charAt(r)] = r + 1;
        }
        return ans;
    }

    /**
     * "abcazabb"
     * "pwwkew"
     * abba
     * l
     * 0
     *   r
     *   2
     * 12
     */
    public int resolve2(String s) {
        Map<Character, Integer> index = new HashMap<>();
        int max = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            l = Math.max(l, index.getOrDefault(c, r));
            max = Math.max(max, r - l + 1);
            System.out.printf("c=%s, l=%d, r=%d, max=%d \n", c, l, r, max);
            index.put(c, r);
        }
        return max;
    }
}
