package lesson17_DynamicProgramming.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberSolitaire {

    public int solution(int[] A) {
        int N = A.length;
        Integer[] result = new Integer[N];
        result[0] = A[0];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < 7 && j <= i; j++) {
                result[i] = result[i] == null ? result[i - j] + A[i] : Math.max(result[i], result[i - j] + A[i]);
            }
        }
        return result[N - 1];
    }

    @Test
    public void testExample() {
        int[] A = { 1, -2, 0, 9, -1, -2 };
        int result = 8;
        assertEquals(result, new NumberSolitaire().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = { 1, -2 };
        int result = -1;
        assertEquals(result, new NumberSolitaire().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1, 2 };
        int result = 3;
        assertEquals(result, new NumberSolitaire().solution(A));
    }

    @Test
    public void testSimple3() {
        int[] A = { -1, -2 };
        int result = -3;
        assertEquals(result, new NumberSolitaire().solution(A));
    }

    @Test
    public void testSimple4() {
        int[] A = { 1, -100, 2 };
        int result = 3;
        assertEquals(result, new NumberSolitaire().solution(A));
    }
}
