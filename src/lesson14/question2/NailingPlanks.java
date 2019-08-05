package lesson14.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * to slow
 * 
 * @author xiong_yi
 *
 */
public class NailingPlanks {

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
        int len = A.length;
        int[] nailedArr = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= k; j++) {

                if (nailedArr[i] == 1) {
                    break;
                }
                // if A[i] ≤ C[k] ≤ B[i] , set nailedArr[i]=1
                if (A[i] <= C[j] && C[j] <= B[i]) {
                    nailedArr[i] = 1;
                    break;
                }

            }
        }
        // if unnailedplanks exist, return false
        for (int n : nailedArr) {
            if (n == 0) {
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
        assertEquals(result, new NailingPlanks().solution(A, B, C));
    }

    @Test
    public void testSimple1() {
        int A[] = { 1 };
        int B[] = { 1 };
        int C[] = { 1 };
        int result = 1;
        assertEquals(result, new NailingPlanks().solution(A, B, C));
    }

    @Test
    public void testSimple2() {
        int A[] = { 1 };
        int B[] = { 1 };
        int C[] = { 2 };
        int result = -1;
        assertEquals(result, new NailingPlanks().solution(A, B, C));
    }

    @Test
    public void testSimple3() {
        int A[] = { 1 };
        int B[] = { 2 };
        int C[] = { 3 };
        int result = -1;
        assertEquals(result, new NailingPlanks().solution(A, B, C));
    }

    @Test
    public void testSimple4() {
        int A[] = { 1 };
        int B[] = { 2 };
        int C[] = { 3, 1 };
        int result = 2;
        assertEquals(result, new NailingPlanks().solution(A, B, C));
    }

}
