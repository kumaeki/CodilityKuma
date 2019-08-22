package lession06_Sorting.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Distinct2 {
    public int solution(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        int dup = 0;
        for (int i = 0; i < N - 1; i++) {
            if (A[i] == A[i + 1]) {
                dup++;
            }
        }
        return N - dup;
    }

    @Test
    public void testExample() {
        int[] A = { 2, 1, 1, 2, 3, 1 };
        int result = 3;
        assertEquals(result, new Distinct2().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = {};
        int result = 0;
        assertEquals(result, new Distinct2().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1 };
        int result = 1;
        assertEquals(result, new Distinct2().solution(A));
    }

}
