package sdflower80.study.algorithm;

import java.util.HashSet;
import java.util.Set;

public class DuplCount {
    public static void main(String[] args) {
        int[] n = new int[]{1, 2, 3, 4, 4, 5, 6, 6, 6, 7};

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int i : n) {
            if (s1.contains(i)) {
                s2.add(i);
            } else {
                s1.add(i);
            }
        }

        System.out.println(s2.size());
    }
}
