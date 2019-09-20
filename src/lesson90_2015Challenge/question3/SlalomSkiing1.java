package lesson90_2015Challenge.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SlalomSkiing1 {

    public int solution(int[] A) {
        int n = A.length;
        int max = getMax(A);
        long[] newA = new long[3 * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            long a = A[i];
            newA[index] = 2 * max + a;
            index++;
            newA[index] = 2 * max - a;
            index++;
            newA[index] = a;
            index++;
        }
        return getMaxCount(newA);
    }

    public int getMaxCount(long[] A) {
        int n = A.length;
        int[] maxCount = new int[n];
        Arrays.fill(maxCount, 1);
        for (int end = 1; end < n; end++) {
            for (int i = 0; i < end; i++) {
                if (A[end] > A[i] && maxCount[i] + 1 > maxCount[end]) {
                    maxCount[end] = maxCount[i] + 1;
                }
            }
        }
        return getMax(maxCount);
    }

    public int getMax(int[] array) {
        // get the max value
        int max = 1;
        for (int a : array) {
            max = Math.max(a, max);
        }
        return max;
    }

    @Test
    public void testExample1() {
        int[] A = { 15, 13, 5, 7, 4, 10, 12, 8, 2, 11, 6, 9, 3 };
        int result = 8;
        assertEquals(result, new SlalomSkiing1().solution(A));
    }

    @Test
    public void testExample2() {
        int[] A = { 1, 5 };
        int result = 2;
        assertEquals(result, new SlalomSkiing1().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = { 1, 2, 3, 4, 5 };
        int result = 5;
        assertEquals(result, new SlalomSkiing1().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1, 2, 5, 4, 3 };
        int result = 5;
        assertEquals(result, new SlalomSkiing1().solution(A));
    }

    @Test
    public void testSimple3() {
        int[] A = { 1, 5, 2, 3, 4 };
        int result = 5;
        assertEquals(result, new SlalomSkiing1().solution(A));
    }

    @Test
    public void testSimple4() {
        int[] A = { 5, 4, 1, 2, 3 };
        int result = 5;
        assertEquals(result, new SlalomSkiing1().solution(A));
    }

    @Test
    public void testSimple5() {
        int[] A = { 1000000000, 999999999, 3, 2, 1 };
        int result = 5;
        assertEquals(result, new SlalomSkiing1().solution(A));
    }

    @Test
    public void testSimple6() {
        int[] A = { 1000000000, 999999999, 1, 3, 2 };
        int result = 4;
        assertEquals(result, new SlalomSkiing1().solution(A));
    }
}
