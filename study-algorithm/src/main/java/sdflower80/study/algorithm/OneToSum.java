package sdflower80.study.algorithm;

public class OneToSum {

    public static void main(String[] args) {
        int n = 100;
        logN(n);

        logN_2(n);

        gauss(n);
    }

    private static void logN_2(int n) {
        int sum2 = 0;
        for(int i = 0; i < n/2; i++) {
            int step = (i+1) + (n-i);
            System.out.println("=>" + (i+1) + "+" + (n-i) + "=" + step);
            sum2 += step;
        }
        System.out.println(sum2);
    }

    private static void logN(int n) {
        int sum1 = 0;
        for(int i = 1; i <= n; i++) {
            sum1+=i;
        }
        System.out.println(sum1);
    }

    private static void gauss(int n) {
        System.out.println(((1 + 100)*100)/2);
    }
}
