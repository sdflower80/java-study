package sdflower80.study.algorithm;

import java.util.Arrays;

public class IpCase {

    public static void main(String[] args) {
        String ipAddr = "1234567";
        /*
        6

        4=>
        1, 1, 1, 4
        1, 1, 2, 3
        1, 1, 3, 2
        1, 1, 4, 1
        */

        /*int result1 = solve(ipAddr);
        System.out.println(result1);

        int result2 = solve2(ipAddr.length());
        System.out.println(result2);*/

        int result3 = countValidIp(ipAddr);
        System.out.println(result3);
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
                    if (ip_arr[3].length() > 0 && ip_arr[3].length() <= 3) {
                        cnt++;
                        System.out.println(Arrays.toString(ip_arr));
                    }
                }
            }
        }
        return cnt;
    }

    static int countValidIp(String str) {
        int count = 0;

        /*
        4 =>
            i: 1 -> 2
            j: 2 -> 3
            4 - 2 - 1 = 3

         */
        for (int i = 1; i < str.length() - 2; i++) {
            for (int j = i + 1; j < str.length() - 1; j++) {
                int n = str.length() - j - 1;
                count += n;
                System.out.printf("(%d - %d) = %d\n", str.length(), j+1, n);
            }
            System.out.println("-");
        }

        return count;
    }

    static int solve2(int n) {
        int c = 0;

        /*
        6
        6-1 = 5 => (1, x)
        5-1 = 4 => (1, 1, x)
        4-1 = 3 => (1, 1, 1, x)
        */
        for (int i = 1; i <= 3; i++) {
            int r1 = n - i;
            for (int j = 1; j <= 3 && r1 > 1; j++) {
                int r2 = r1 - j;
                for (int k = 1; k <= 3 && r2 > 1; k++) {
                    int r3 = r2 - k;
                    if (r3 >= 1 && r3 <= 3) {
                        System.out.printf("%d, %d, %d\n", r1, r2, r3);
                        c += 1;
                    }
                }
            }
        }
        return c;
    }
}
