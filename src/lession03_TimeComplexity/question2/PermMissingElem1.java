package lession03_TimeComplexity.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class PermMissingElem1 {
    public int solution(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 1;
        }
        Arrays.parallelSort(A);
        for (int i = 0; i < len; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    @Test
    public void test0() {
        int[] in = { 1, 2, 3, 4, 6 };
        int out = 5;
        assertEquals(out, solution(in));
    }

    @Test
    public void test1() {
        int[] in = { 2, 3, 1, 5 };
        int out = 4;
        assertEquals(out, solution(in));
    }

    @Test
    public void test2() {
        int[] in = { 6, 5, 3, 2, 1 };
        int out = 4;
        assertEquals(out, solution(in));
    }

    @Test
    public void test3() {
        int[] in = {};
        int out = 1;
        assertEquals(out, solution(in));
    }

    @Test
    public void test4() {
        int[] in = { 1 };
        int out = 2;
        assertEquals(out, solution(in));
    }

    @Test
    public void test5() {
        int[] in = { 2 };
        int out = 1;
        assertEquals(out, solution(in));
    }
}
