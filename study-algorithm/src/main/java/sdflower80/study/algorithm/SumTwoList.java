package sdflower80.study.algorithm;

/**
 * @author sdflower
 * @since 12/06/2020 12:37
 */
public class SumTwoList {
    public static void main(String[] args) {
        int[] one = new int[]{1, 2, 8};
        int[] two = new int[]{1, 1, 1, 1, 2};

        int[] result = resolve1(one, two);
        for (int i : result) {
            System.out.print(i);
        }

    }

    public static int[] resolve1(int[] one, int[] two) {

        int a = convertArrToNum(one);
        int b = convertArrToNum(two);

        int total = a + b;

        int[] result = new int[10];
        int mok = total;
        int idx = 0;
        while(mok > 0) {
            result[idx] = mok % 10;
            mok = mok / 10;
            idx ++;
        }

        int[] result2 = new int[idx];
        for(int i = (idx-1), j=0; i >= 0; i--, j++) {
            result2[j] = result[i];
        }

        return result2;
    }

    private static int convertArrToNum(int[] one) {
        int a = 0;
        for (int i = one.length - 1, d = 0; i >= 0; i--, d++) {
            a += one[i] * (int)(Math.pow(10, d));
        }
        return a;
    }
}
