package sdflower80.study.algorithm;

import java.util.ArrayList;
import java.util.List;

public class IpCase {

    public static void main(String[] args) {
        String ipAddr = "111425";
        
        // int cnt = solve3(ipAddr);
        // System.out.println("ip case count is " + cnt);
        // String[] result = split(ipAddr, 2);
        // System.out.printf("a=%s, b=%s", result[0], result[1]);

        List<String> combinations = generateIPCombinations(ipAddr);
        System.out.println("IP case: " + combinations.size());
    }

    private static int solve3(String ipAddr) {
        
        /*
         * 1, 1, 1, *
         * 1, 1, 2, *
         * 1, 1, 3, *
         * 1, 2, 1, *
         * 1, 2, 2, *
         * 1, 2, 3, *
         * 1, 3, 1, *
         * 1, 3, 2, *
         * 1, 3, 3, *
         */
        String tmp = ipAddr;
        int cnt = 0;
        // String[] arr = null;
        for(int i = 1; i <= 3; i ++) {
            String[] arr = subsAndSplit(tmp, i);
            String a = arr[0];
            if (a.length() == 0 || Integer.parseInt(a) > 255) break;

            for (int j = 1; j <= 3; j ++) {
                String[] brr = subsAndSplit(arr[1], j);
                String b = brr[0];
                if (b.length() == 0 || Integer.parseInt(b) > 255) break;

                for(int k = 1; k <= 3; k ++) {
                    String[] crr = subsAndSplit(brr[1], k);
                    String c = crr[0];
                    String d = crr[1];

                    if (c.length() == 0 || d.length() == 0 || d.length() > 3 || Integer.parseInt(c) > 255 || Integer.parseInt(d) > 255) {
                        System.out.printf("%s.%s.%s.%s => break.\n", a, b, c, d);
                        break;
                    }
                    cnt ++;
                    System.out.printf("%s.%s.%s.%s => normal. cnt=%d\n", a, b, c, d, cnt);
                }
                // String[] ips = splitIp(ipAddr, j, i);
                // for(int g = 0; g < ips.length; g ++) {
                //     System.out.printf("%s,", ips[g]);
                // }
                // System.out.println("\n");
            }
        }

        return cnt;
    }

    private static String[] subsAndSplit(String src, int ln) {
        if (src == null || src.length() <= 0) {
            return new String[] {"", ""};
        }

        if (src.length() < ln) {
            return new String[] {src, ""};
        }

        if (ln == 0) {
            return new String[] {"", src};
        }

        String a = src.substring(0, ln);
        String b = src.length() == ln ? "" : src.substring(ln);
        return new String[] {a, b};
    }

    private static List<String> generateIPCombinations(String input) {
        List<String> combinations = new ArrayList<>();
        generateIPCombinationsHelper(input, 0, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private static void generateIPCombinationsHelper(String input, int start, int segments,
                                                     StringBuilder current, List<String> combinations) {
        if (segments == 4 && start == input.length()) {
            combinations.add(current.toString());
            return;
        }

        if (segments == 4 || start == input.length()) {
            return;
        }

        for (int i = 1; i <= 3 && start + i <= input.length(); i++) {
            String segment = input.substring(start, start + i);
            if (isValidSegment(segment)) {
                if (current.length() > 0) {
                    current.append('.');
                }
                current.append(segment);

                generateIPCombinationsHelper(input, start + i, segments + 1, current, combinations);

                if (current.length() > segment.length()) {
                    current.delete(current.length() - segment.length() - 1, current.length());
                } else {
                    current.deleteCharAt(current.length() - 1);
                }
            }
        }
    }

    private static boolean isValidSegment(String segment) {
        if (segment.charAt(0) == '0' && segment.length() > 1) {
            return false; // Leading zero is not allowed except for 0 itself.
        }

        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }
}
