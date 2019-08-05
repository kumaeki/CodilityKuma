package lesson14.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class NailingPlanks3 {

    public int solution(int[] A, int[] B, int[] C) {
        int M = C.length;
        // max position
        int mp = 2 * M + 1;
        int[] nails = new int[mp];
        // set bigger than the  biggest position
        Arrays.fill(nails, 100000);
        // value range : 0 ~ M-1
        for (int i = M - 1; i >= 0; i--) {
            nails[C[i]] = i;
        }
        int[] planks = new int[mp];
        // value range : 1 ~ 2*M
        for (int i = 0; i < A.length; i++) {
            planks[B[i]] = Math.max(planks[B[i]], A[i]);
        }

        // position List
        LinkedList<Integer> pl = new LinkedList<Integer>();
        // prevoius position
        int preL = 0;
        int preR = 0;
        int result = 0;
        for (int i = 1; i < mp; i++) {
            if (planks[i] > preL) {
                int left = planks[i];
                preL = left;
                while (!pl.isEmpty() && pl.getFirst() < left) {
                    pl.removeFirst();
                }

                int right = Math.max(preR, left);
                preR = right;
                for (; right <= i; right++) {
                    while (!pl.isEmpty() && nails[pl.getLast()] >= nails[right]) {
                        pl.removeLast();
                    }
                    pl.addLast(right);
                }
                result = Math.max(result, nails[pl.getFirst()]);
                if (result == 100000) {
                    return -1;
                }

            }
        }

        return result + 1;
    }

    @Test
    public void testExample() {
        int A[] = { 1, 4, 5, 8 };
        int B[] = { 4, 5, 9, 10 };
        int C[] = { 4, 6, 7, 10, 2 };
        int result = 4;
        assertEquals(result, new NailingPlanks3().solution(A, B, C));
    }

    @Test
    public void testSimple1() {
        int A[] = { 1 };
        int B[] = { 1 };
        int C[] = { 1 };
        int result = 1;
        assertEquals(result, new NailingPlanks3().solution(A, B, C));
    }

    @Test
    public void testSimple2() {
        int A[] = { 1 };
        int B[] = { 1 };
        int C[] = { 2 };
        int result = -1;
        assertEquals(result, new NailingPlanks3().solution(A, B, C));
    }

    @Test
    public void testSimple3() {
        int A[] = { 1 };
        int B[] = { 2 };
        int C[] = { 3, 3 };
        int result = -1;
        assertEquals(result, new NailingPlanks3().solution(A, B, C));
    }

    @Test
    public void testSimple4() {
        int A[] = { 1 };
        int B[] = { 2 };
        int C[] = { 3, 1 };
        int result = 2;
        assertEquals(result, new NailingPlanks3().solution(A, B, C));
    }

}
