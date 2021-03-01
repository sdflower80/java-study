package sdflower80.study.algorithm;

import java.util.*;

/**
 * Compression String #1
 * - problem: Compress the count of alphabet [a-z]
 * - input / output :
 * - a1a1a1 --> a3
 * - a3c9b2c1 --> a3c10b2
 * - a3c22b1c2 --> a3c24b1
 * - a3c22a4b1c2 --> a7c24b1
 */
public class CompressionString {

    private final static int MAX_NUM_STACK_SIZE = 3;

    public String solve_raw_style(String s) {
        int[] char_num = new int[128];
        int[] char_dic = new int[128];

        char[] char_list = new char[128];
        int char_list_idx = 0;

        int[] num_stack = new int[MAX_NUM_STACK_SIZE];
        int num_stack_idx = 0;


        char prev = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // 숫자
                num_stack[num_stack_idx++] = Character.getNumericValue(c);
            } else {
                // 문자
                if (prev != 0) {
                    int num = 0;
                    if (num_stack_idx > 0) {
                        num = arrayToNum(num_stack, num_stack_idx);
                        num_stack_idx = 0;
                        num_stack = new int[MAX_NUM_STACK_SIZE];
                    }

                    char_num[prev] += num;
                }

                if (char_dic[c] == 0) {
                    char_list[char_list_idx++] = c;
                }

                char_dic[c] = 1;
                prev = c;
            }
        }

        if (num_stack_idx > 0) {
            char_num[prev] += arrayToNum(num_stack, num_stack_idx);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < char_list_idx; i++) {
            result.append(char_list[i]);
            result.append(char_num[char_list[i]]);
        }

        return result.toString();
    }

    int arrayToNum(int[] c, int length) {
        int num = 0;
        for(int i=0; i<length; i++) {
            num += c[i] * Math.pow(10, length-1-i);
        }
        return num;
    }

    public String solve_java_style(String str) {

        Map<Character, Integer> charSum = new HashMap<>();
        List<Character> charOrder = new ArrayList<>();
        List<Integer> numStack = new ArrayList<>();

        Character prev = 0;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                numStack.add(Character.getNumericValue(c));
            } else {
                if (prev != 0) {
                    charSum.put(prev, charSum.getOrDefault(prev, 0) + arrayToNum(numStack));
                    numStack.clear();
                }

                if (!charSum.containsKey(c)) {
                    charOrder.add(c);
                }

                prev = c;
            }
        }

        if (numStack.size() > 0) {
            charSum.put(prev, charSum.getOrDefault(prev, 0) + arrayToNum(numStack));
        }

        StringBuilder result = new StringBuilder();
        for (Character c : charOrder) {
            result.append(c);
            result.append(charSum.get(c));
        }

        return result.toString();
    }

    Integer arrayToNum(List<Integer> c) {
        int num = 0;
        for (int i = 0; i < c.size(); i++) {
            num += c.get(i) * Math.pow(10, c.size() - 1 - i);
        }
        return num;
    }

    class CharSum {
        public Character c;
        public Integer sum;
        public Integer order;
    }

    public static void main(String[] args) {
        CompressionString cs = new CompressionString();

        /*String result1 = cs.solve_raw_style("a3c22a4b1c2");
        System.out.println(result1);*/

        String result2 = cs.solve_java_style("a3c22a4b1c2");
        System.out.println(result2);

 /*       int[] t = new int[]{1};
        int i = cs.arrayToNum(t);
        System.out.println(i);*/

//        System.out.println(Character.forDigit(1, 10));
    }
}
