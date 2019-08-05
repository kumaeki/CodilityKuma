package lesson14.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class NailingPlanks4 {

    public int solution(int[] A, int[] B, int[] C) {

        // number of nails
        int nailNum = C.length;
        // number of position
        int posNum = 2 * nailNum + 1;

        // smallest index of nails in the C
        // value range : 0 ~ C.length -1
        int[] nailArr = new int[posNum];
        // set -1 if there is no nail
        Arrays.fill(nailArr, -1);
        for (int i = nailNum - 1; i >= 0; i--) {
            nailArr[C[i]] = i;
        }

        // the biggest left of planks(right is the B[i])
        // value range : 1 ~ 2*C.length
        int[] planks = new int[posNum];
        for (int i = 0; i < A.length; i++) {
            planks[B[i]] = Math.max(planks[B[i]], A[i]);
        }

        // the position of previous start
        int preStart = 0;
        int start = 0;
        int result = 0;
        // queue of nail's position
        LinkedList<Integer> nailPosArr = new LinkedList<Integer>();
        for (int i = 1; i < posNum; i++) {
            if (planks[i] > preStart) {
                preStart = planks[i];
                while (!nailPosArr.isEmpty() && nailPosArr.getFirst() < planks[i]) {
                    nailPosArr.removeFirst();
                }

                start = Math.max(start, planks[i]);
                for (int j = start; j <= i; j++) {
                    if (nailArr[j] == -1) {
                        continue;
                    }
                    // find the biggest index of nail in C
                    while (!nailPosArr.isEmpty()) {
                        if (nailArr[nailPosArr.getLast()] == -1 || nailArr[nailPosArr.getLast()] >= nailArr[j]) {
                            nailPosArr.removeLast();
                        } else {
                            break;
                        }
                    }
                    nailPosArr.addLast(j);
                }

                if (nailPosArr.isEmpty() || nailArr[nailPosArr.getFirst()] == -1) {
                    return -1;
                } else {
                    result = Math.max(result, nailArr[nailPosArr.getFirst()]);
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
        assertEquals(result, new NailingPlanks4().solution(A, B, C));
    }

    @Test
    public void testSimple1() {
        int A[] = { 1 };
        int B[] = { 1 };
        int C[] = { 1 };
        int result = 1;
        assertEquals(result, new NailingPlanks4().solution(A, B, C));
    }

    @Test
    public void testSimple2() {
        int A[] = { 1 };
        int B[] = { 1 };
        int C[] = { 2 };
        int result = -1;
        assertEquals(result, new NailingPlanks4().solution(A, B, C));
    }

    @Test
    public void testSimple3() {
        int A[] = { 1 };
        int B[] = { 2 };
        int C[] = { 3, 3 };
        int result = -1;
        assertEquals(result, new NailingPlanks4().solution(A, B, C));
    }

    @Test
    public void testSimple4() {
        int A[] = { 1 };
        int B[] = { 2 };
        int C[] = { 3, 1 };
        int result = 2;
        assertEquals(result, new NailingPlanks4().solution(A, B, C));
    }

}
