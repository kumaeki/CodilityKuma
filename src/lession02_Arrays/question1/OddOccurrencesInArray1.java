package lession02_Arrays.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class OddOccurrencesInArray1 {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for (int a : A) {
            if (set.contains(a)) {
                set.remove(a);
            } else {
                set.add(a);
            }
        }
        return set.iterator().next();
    }

    @Test
    public void test0() {
        int[] in = { 9, 3, 9, 3, 9, 7, 9 };
        int out = 7;
        assertEquals(out, solution(in));
    }

    @Test
    public void test1() {
        int[] in = { 1, 2, 3, 1, 2, 3, 4 };
        int out = 4;
        assertEquals(out, solution(in));
    }

    @Test
    public void test2() {
        int[] in = { 3 };
        int out = 3;
        assertEquals(out, solution(in));
    }

}
