package sdflower80.study.algorithm;

public class NonRepeatChar {

    static char[] index = new char[256];

    static void indexing(String str) {
        for(int i=0; i < str.length(); i++) {
            index[str.charAt(i)] ++;
        }
    }

    public static int solve(String input) {
        indexing(input);

        for(int i=0; i<input.length(); i++) {
            if (index[input.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int result = solve("java");
        System.out.println(result);
    }
}
