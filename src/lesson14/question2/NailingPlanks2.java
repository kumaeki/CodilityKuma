package lesson14.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NailingPlanks2 {

    public int solution(int[] A, int[] B, int[] C) {
        int start = 0;
        int end = C.length - 1;
        int result = -1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (isAllNailed(A, B, C, middle)) {
                end = middle - 1;
                result = middle + 1;
            } else {
                start = middle + 1;
            }
        }
        return result;
    }

    boolean isAllNailed(int[] A, int[] B, int[] C, int k) {
        int M = C.length;
        // position Array
        int[] pa = new int[2 * M + 1];
        // if nail exist , set 1
        for (int i = 0; i <= k; i++) {
            pa[C[i]] = 1;
        }

        // set prefix sum
        for (int i = 1; i < pa.length; i++) {
            pa[i] += pa[i - 1];
        }

        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (pa[A[i] - 1] == pa[B[i]]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testExample() {
        int A[] = { 1, 4, 5, 8 };
        int B[] = { 4, 5, 9, 10 };
        int C[] = { 4, 6, 7, 10, 2 };
        int result = 4;
        assertEquals(result, new NailingPlanks2().solution(A, B, C));
    }

    @Test
    public void testSimple1() {
        int A[] = { 1 };
        int B[] = { 1 };
        int C[] = { 1 };
        int result = 1;
        assertEquals(result, new NailingPlanks2().solution(A, B, C));
    }

    @Test
    public void testSimple2() {
        int A[] = { 1 };
        int B[] = { 1 };
        int C[] = { 2 };
        int result = -1;
        assertEquals(result, new NailingPlanks2().solution(A, B, C));
    }

    @Test
    public void testSimple3() {
        int A[] = { 1 };
        int B[] = { 2 };
        int C[] = { 3, 3 };
        int result = -1;
        assertEquals(result, new NailingPlanks2().solution(A, B, C));
    }

    @Test
    public void testSimple4() {
        int A[] = { 1 };
        int B[] = { 2 };
        int C[] = { 3, 1 };
        int result = 2;
        assertEquals(result, new NailingPlanks2().solution(A, B, C));
    }

}
