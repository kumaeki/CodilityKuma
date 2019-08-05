package lession02_Arrays.question2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class CyclicRotation2 {
    public int[] solution(int[] A, int K) {
        int len = A.length;
        if (len == 0 || len == 1) {
            return A;
        }

        int index = len - (K % len);
        int[] resultArr = new int[len];
        for (int i = 0; i < len; i++) {
            if (i + index < len) {
                resultArr[i] = A[i + index];
            } else {
                resultArr[i] = A[i + index - len];
            }

        }

        return resultArr;
    }

    @Test
    public void test0() {
        int[] in = { 5, -1000 };
        int[] out = { -1000, 5 };
        assertArrayEquals(out, solution(in, 5));
    }

    @Test
    public void test1() {
        int[] in = { 3, 8, 9, 7, 6 };
        int[] out = { 9, 7, 6, 3, 8 };
        assertArrayEquals(out, solution(in, 3));
    }

    @Test
    public void test2() {
        int[] in = { 0, 0, 0 };
        int[] out = { 0, 0, 0 };
        assertArrayEquals(out, solution(in, 1));
    }

    @Test
    public void test3() {
        int[] in = { 1, 2, 3, 4 };
        int[] out = { 1, 2, 3, 4 };
        assertArrayEquals(out, solution(in, 4));
    }

}
