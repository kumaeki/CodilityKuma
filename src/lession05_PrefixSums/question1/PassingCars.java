package lession05_PrefixSums.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PassingCars {
    public int solution(int[] A) {
        int sum = 0;
        int len = A.length;
        int[] B = new int[len];
        B[0] = A[0];
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] + A[i];
        }
        for (int i = 0; i < len; i++) {
            if (A[i] == 0) {
                sum += (B[len - 1] - B[i]);
                if (sum > 1000000000) {
                    return -1;
                }
            }
        }
        return sum;
    }

    @Test
    public void testExample() {
        int[] A = { 0, 1, 0, 1, 1 };
        int result = 5;
        assertEquals(result, new PassingCars().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = { 0 };
        int result = 0;
        assertEquals(result, new PassingCars().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1 };
        int result = 0;
        assertEquals(result, new PassingCars().solution(A));
    }

    @Test
    public void testSimple3() {
        int[] A = { 1, 1 };
        int result = 0;
        assertEquals(result, new PassingCars().solution(A));
    }

    @Test
    public void testSimple4() {
        int[] A = { 0, 0 };
        int result = 0;
        assertEquals(result, new PassingCars().solution(A));
    }

    @Test
    public void testSimple5() {
        int[] A = { 0, 1 };
        int result = 1;
        assertEquals(result, new PassingCars().solution(A));
    }

    @Test
    public void testSimple6() {
        int[] A = { 1, 0 };
        int result = 0;
        assertEquals(result, new PassingCars().solution(A));
    }
}
