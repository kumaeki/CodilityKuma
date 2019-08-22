package lession06_Sorting.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MaxProductOfThree {
    public int solution(int[] A) {
        int N = A.length;
        Arrays.parallelSort(A);
        return Math.max(A[0] * A[1] * A[N - 1], A[N - 1] * A[N - 2] * A[N - 3]);
    }

    @Test
    public void testExample() {
        int[] A = { -3, 1, 2, -2, 5, 6 };
        assertEquals(60, new MaxProductOfThree().solution(A));
    }

    @Test
    public void test3() {
        int[] A = { 1, 2, 3 };
        assertEquals(6, new MaxProductOfThree().solution(A));
    }

    @Test
    public void test4_1() {
        int[] A = { 1, 2, 3, 4 };
        assertEquals(24, new MaxProductOfThree().solution(A));
    }

    @Test
    public void test4_2() {
        int[] A = { 1, 2, -3, 4 };
        assertEquals(8, new MaxProductOfThree().solution(A));
    }

    @Test
    public void test5_1() {
        int[] A = { 1, 2, -3, 4, -10 };
        assertEquals(120, new MaxProductOfThree().solution(A));
    }

    @Test
    public void test5_2() {
        int[] A = { 1, 2, -3, 4, 0 };
        assertEquals(8, new MaxProductOfThree().solution(A));
    }

    @Test
    public void test10_1() {
        int[] A = { 1, -2, 3, -4, 5, 6, -7, 8, -9, 10 };
        assertEquals(630, new MaxProductOfThree().solution(A));
    }

    @Test
    public void test10_2() {
        int[] A = { -10, -8, 1, 2, 3, 4, 5, 6, 7, 8 };
        assertEquals(640, new MaxProductOfThree().solution(A));
    }
}
