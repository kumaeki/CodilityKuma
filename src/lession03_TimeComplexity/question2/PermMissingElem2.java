package lession03_TimeComplexity.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PermMissingElem2 {
    public int solution(int[] A) {
        int len = A.length;
        int[] resultArr = new int[len + 1];
        for (int a : A) {
            resultArr[a - 1] = a;
        }
        for (int i = 0; i < resultArr.length; i++) {
            if (resultArr[i] == 0) {
                return i + 1;
            }
        }
        return 1;
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
