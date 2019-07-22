package lesson10.question4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Solution2 {
    public int solution(int[] A) {
        int len = A.length;
        // next peak List
        int[] npl = getNextPeakList(A);
        if (len < 3) {
            return 0;
        }
        // max flag number
        int max = 0;
        // flag number
        int fn = (int) Math.sqrt(len - 2) + 1;
        for (; fn > 0; fn--) {
            // position
            int pos = 0;
            // set flag count
            int flgcnt = 0;
            while (pos < len - 1 && flgcnt < fn) {
                pos = npl[pos];
                if (pos == -1) {
                    break;
                }
                pos = pos + fn;
                flgcnt++;
            }
            if (flgcnt == fn) {
                max = fn;
                break;
            }
        }
        return max;
    }

    int[] getNextPeakList(int[] A) {
        int ln = A.length;
        // next peak list
        int[] npl = new int[ln];
        npl[ln - 1] = -1;
        for (int i = ln - 2; i > 0; i--) {
            if (A[i] > A[i + 1] && A[i - 1] < A[i]) {
                npl[i] = i;
            } else {
                npl[i] = npl[i + 1];
            }
        }
        if (ln > 1) {
            npl[0] = npl[1];
        }
        return npl;
    }

    @Test
    public void testExample() {
        int[] A = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
        assertEquals(3, new Solution2().solution(A));
    }

    @Test
    public void testSingle() {
        int[] A = { 1 };
        assertEquals(0, new Solution2().solution(A));
    }

    @Test
    public void testDouble() {
        int[] A = { 1, 2 };
        assertEquals(0, new Solution2().solution(A));
    }

    @Test
    public void testThree() {
        int[] A = { 1, 2, 1 };
        assertEquals(1, new Solution2().solution(A));
    }

    @Test
    public void testFour() {
        int[] A = { 1, 2, 2, 1 };
        assertEquals(0, new Solution2().solution(A));
    }

    @Test
    public void testFive() {
        int[] A = { 1, 2, 1, 2, 1 };
        assertEquals(2, new Solution2().solution(A));
    }

    @Test
    public void testSimple() {
        int[] A = { 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 };
        assertEquals(2, new Solution2().solution(A));
    }
}
