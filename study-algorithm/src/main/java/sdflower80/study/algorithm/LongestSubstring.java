package sdflower80.study.algorithm;

import java.util.Arrays;

/**
 * @author sdflower
 * @since 24/06/2020 14:36
 */
public class LongestSubstring {

    public static void main(String[] args) {
        int pwwkew = new LongestSubstring().lengthOfLongestSubstring("pwwk");
        System.out.println(pwwkew);

        int[] index = new int[128];
        System.out.println(Math.max(index["p".charAt(0)], 0));
    }

    public int lengthOfLongestSubstring(String s) {
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
}
