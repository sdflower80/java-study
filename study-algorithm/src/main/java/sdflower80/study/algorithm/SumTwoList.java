package sdflower80.study.algorithm;

import java.util.Arrays;

/**
 * @author sdflower
 * @since 12/06/2020 12:37
 */
public class SumTwoList {
    public static void main(String[] args) {
        int[] one = new int[]{1, 2, 8};
        int[] two = new int[]{2, 2, 1, 3, 4};

        // System.out.println(convertInt(two));
        System.out.println(128%1000);
    }

    public static int[] resolve(int[] one, int[] two) {
        return new int[]{};
    }

    public static int convertInt(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result = (result * 10) + i;
        }
        return result;
    }

    public static int[] convertArr(int num) {
//        Arrays.copyOf()

        int[] result = new int[10];
        int moc = num;
        while(true) {
            int mod = moc % 10;
            moc = num / 10;
            if (moc < 1) {
                break;
            }
        }
        return new int[]{};
    }

    public static int[] resolve1(int[] one, int[] two) {
        StringBuilder num1 = new StringBuilder();
        for (int i : one) {
            num1.append(i);
        }

        StringBuilder num2 = new StringBuilder();
        for (int i : two) {
            num2.append(i);
        }

        String total = String.valueOf(Long.parseLong(num1.toString()) + Long.parseLong(num2.toString()));
        char[] chars = total.toCharArray();
        int[] result = new int[chars.length];
        for (int i = 0; i < total.length(); i ++) {
            result[i] = Character.getNumericValue(chars[i]);
        }
        return result;
    }

    public static int[] resolve2(int[] one, int[] two) {
        int cnt = one.length > two.length ? one.length : two.length;

        int diff = one.length - two.length;
        diff = diff < 0 ? (-1) * diff : diff;

        int[] total = new int[cnt];
        int next_over = 0;
        int curr_over = 0;
        for(int i=cnt-1; i >= 0; i--) {
            curr_over = next_over;

            int a_idx = one.length < two.length ? i - diff : i;
            int b_idx = one.length > two.length ? i - diff : i;

            int a = a_idx < one.length && a_idx >= 0 ? one[a_idx] : 0;
            int b = b_idx < two.length && b_idx >= 0 ? two[b_idx] : 0;
            int c = a + b;
            if (c >= 10) {
                c -= 10;
                next_over = 1;
            } else {
                next_over = 0;
            }
            total[i] = c + curr_over;
            System.out.println(String.format("a=%s, b=%s, cur_over=%s, nex_over=%s, total=%s",
                    a, b, curr_over, next_over, total[i]));
        }

        if (next_over > 0) {
            total[0] = next_over;
        }

        return total;
    }
}
