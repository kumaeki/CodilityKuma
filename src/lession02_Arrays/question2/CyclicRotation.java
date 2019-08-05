package lession02_Arrays.question2;

import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int len = A.length;
        if (len < 2 || K % len == 0) {
            return A;
        }
        int[] result = new int[len];
        int distance = K % len;
        for (int i = 0; i < len; i++) {
            result[(i + distance) % len] = A[i];
        }
        return result;
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
