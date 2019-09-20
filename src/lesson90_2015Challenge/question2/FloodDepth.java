package lesson90_2015Challenge.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FloodDepth {
    public int solution(int[] A) {
        int n = A.length;
        int left = A[0];
        int bottom = A[0];
        int depth = 0;

        for (int i = 1; i < n; i++) {
            int depthLeft = left - bottom;
            int depthRight = A[i] - bottom;
            if (depthLeft > 0 && depthRight > 0) {
                depth = Math.max(depth, Math.min(depthLeft, depthRight));
            }
            if (A[i] >= left) {
                left = A[i];
                bottom = A[i];
            } else if (A[i] < bottom) {
                bottom = A[i];
            }
        }
        return depth;
    }

    @Test
    public void testEamaple1() {
        int[] A = { 1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2 };
        int result = 2;
        assertEquals(result, new FloodDepth().solution(A));
    }

    @Test
    public void testEamaple2() {
        int[] A = { 5, 8 };
        int result = 0;
        assertEquals(result, new FloodDepth().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = { 5 };
        int result = 0;
        assertEquals(result, new FloodDepth().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 5, 8, 5 };
        int result = 0;
        assertEquals(result, new FloodDepth().solution(A));
    }

    @Test
    public void testSimple3() {
        int[] A = { 5, 8, 5, 8 };
        int result = 3;
        assertEquals(result, new FloodDepth().solution(A));
    }
}
