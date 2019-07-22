package lesson10.question4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Solution {
    public int solution(int[] A) {
        int len = A.length;
        if (len < 3) {
            return 0;
        }
        // peak index List
        ArrayList<Integer> pl = new ArrayList<Integer>();
        for (int i = 1; i < len - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                pl.add(i);
            }
        }
        if (pl.size() < 2) {
            return pl.size();
        }
        // flag number
        int plen = pl.size();
        for (int fn = plen; fn > 1; fn--) {

            int start = 0;
            int next = 1;
            // flag count
            int fc = 1;
            while (next < plen && (plen - next) >= (fn - fc)) {
                if (pl.get(start) + fn > pl.get(next)) {
                    next++;
                } else {
                    start = next;
                    next++;
                    fc++;
                }
                if (fc == fn) {
                    return fn;
                }
            }
        }

        return 1;
    }

    @Test
    public void testExample() {
        int[] A = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
        assertEquals(3, new Solution().solution(A));
    }

    @Test
    public void testSingle() {
        int[] A = { 1 };
        assertEquals(0, new Solution().solution(A));
    }

    @Test
    public void testDouble() {
        int[] A = { 1, 2 };
        assertEquals(0, new Solution().solution(A));
    }

    @Test
    public void testThree() {
        int[] A = { 1, 2, 1 };
        assertEquals(1, new Solution().solution(A));
    }

    @Test
    public void testFour() {
        int[] A = { 1, 2, 2, 1 };
        assertEquals(0, new Solution().solution(A));
    }

    @Test
    public void testFive() {
        int[] A = { 1, 2, 1, 2, 1 };
        assertEquals(2, new Solution().solution(A));
    }
    
    @Test
    public void testSimple() {
        int[] A = { 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 };
        assertEquals(2, new Solution().solution(A));
    }
}
