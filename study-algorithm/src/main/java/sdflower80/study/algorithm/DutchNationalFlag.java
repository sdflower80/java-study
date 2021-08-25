package sdflower80.study.algorithm;

public class DutchNationalFlag {

    public int[] solve(int[] input) {

        int cur = 0;
        int start = 0;
        int end = input.length-1;

        while(cur <= end) {
            if (input[cur] == 0) {
                input[cur] = input[start];
                input[start] = 0;
                start ++;
                cur ++;
            } else if (input[cur] == 2) {
                input[cur] = input[end];
                input[end] = 2;
                end --;
            } else if (input[cur] == 1) {
                cur ++;
            } else {
                throw new IllegalStateException("처리할수 없는 값. input[" + cur + "]="+input[cur]);
            }
            System.out.printf("cur=%d, start=%d, end=%d\n", cur, start, end);
        }

        return input;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 0, 2, 2, 1, 0};

        int[] result = new DutchNationalFlag().solve(input);
        for (int i : result) {
            System.out.print(i);
        }
    }
}
