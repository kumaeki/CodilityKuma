package lesson17_DynamicProgramming.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MinAbsSum1 {
    public int solution(int[] A) {
        int N = A.length;
        if (N == 0)
            return 0;
        for (int i = 0; i < N; i++) {
            if (A[i] < 0)
                A[i] = 0 - A[i];
        }

        int[][] result = new int[N][];
        result[0] = new int[] { A[0] };

        for (int i = 1; i < N; i++) {
            int oldlen = result[i - 1].length;
            int newlen = oldlen * 2;
            result[i] = new int[newlen];
            int newindex = 0;
            for (int j = 0; j < oldlen; j++) {
                result[i][newindex] = result[i - 1][j] + A[i];
                newindex++;
                result[i][newindex] = result[i - 1][j] - A[i];
                newindex++;
            }
        }

        int[] array = result[N - 1];
        int min = Math.abs(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) < min) {
                min = Math.abs(array[i]);
            }
        }

        return min;
    }

    @Test
    public void testExample() {
        int[] A = { 1, 5, 2, -2 };
        int result = 0;
        assertEquals(result, new MinAbsSum1().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = {};
        int result = 0;
        assertEquals(result, new MinAbsSum1().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1, 2 };
        int result = 1;
        assertEquals(result, new MinAbsSum1().solution(A));
    }

    @Test
    public void testSimple3() {
        int[] A = { 1, 2, 100 };
        int result = 97;
        assertEquals(result, new MinAbsSum1().solution(A));
    }
    
    @Test
    public void testSimple4() {
        int[] A = { 91, 92, 93, 94, 95, 96, 97 };
        int result = 82;
        assertEquals(result, new MinAbsSum1().solution(A));
    }
}
