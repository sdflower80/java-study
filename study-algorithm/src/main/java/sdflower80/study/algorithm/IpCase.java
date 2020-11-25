package sdflower80.study.algorithm;

import java.util.Arrays;

public class IpCase {



    public static void main(String[] args) {
        String ipAddr = "111234";
        // 1.1.1.2345 (x) 7 -1 -1 -1 = 4
        // 1.1.12.345 (o) 7 -1 -1 -2
        // 1.1.123.45 (o)
        // 1.11.2.345
        // 1.11.23.45
        // 1.11.234.5

        // 1.1.2.1 == 1.1.11.2
        // 1.1.2.2
        // 1.1.2.3

        int result = solve(ipAddr);
        System.out.println(result);
    }

    private static int solve(String ipAddr) {
        int cnt = 0;
        String[] ip_arr = new String[4];

        String i_str = ipAddr;
        for (int i = 0; i < 3 && i_str.length() >= (i + 1); i++) {
            ip_arr[0] = i_str.substring(0, i + 1);

            String j_str = i_str.substring(i + 1);
            for (int j = 0; j < 3 && j_str.length() >= (j + 1); j++) {
                ip_arr[1] = j_str.substring(0, j + 1);

                String k_str = j_str.substring(j + 1);
                for (int k = 0; k < 3 && k_str.length() >= (k + 1); k++) {
                    ip_arr[2] = k_str.substring(0, k + 1);
                    ip_arr[3] = k_str.substring(k + 1);
                    if (ip_arr[3].length() > 0) {
                        cnt ++;
                        System.out.println(Arrays.toString(ip_arr));
                    }
                }
            }
        }
        return cnt;
    }
}
