package lession06.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // to slow
    public int solution(int[] A) {

        int result = 0;
        int len = A.length;
        if (len < 3) {
            return result;
        }

        int tmp = 0;
        int posIndex = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] <= 0) {
                posIndex++;
                continue;
            }
            for (int j = 0; j < len - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }
            }
        }

        for (int i = len - 1; i >= posIndex + 2; i--) {
            if (A[i] - A[i - 1] < A[i - 2]) {
                result = 1;
                break;
            }
        }

        return result;
    }

    public int solution2(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        List<Integer> l = new LinkedList<Integer>();
        for (int i : A) {
            if (i > 0) {
                l.add(i);
            }
        }
        int slen = l.size();
        if (slen < 3) {
            return 0;
        }
        Collections.sort(l);

        for (int i = 0; i < slen - 2; i++) {
            if (l.get(i) > l.get(i + 2) - l.get(i + 1)) {
                return 1;
            }
        }
        return 0;
    }

    @Test
    public void testExample1() {
        int[] A = { 10, 2, 3, 1, 8, 20 };
        assertEquals(1, new Solution().solution2(A));
    }

    @Test
    public void testExample2() {
        int[] A = { 10, 50, 5, 1 };
        assertEquals(0, new Solution().solution2(A));
    }

    @Test
    public void test2Element() {
        int[] A = { 10, 50 };
        assertEquals(0, new Solution().solution2(A));
    }

    @Test
    public void test3Element() {
        int[] A = { 5, 3, 3 };
        assertEquals(1, new Solution().solution2(A));
    }

    @Test
    public void testNegative() {
        int[] A = { 10, 2, 3, 1, 8, -20, 0 };
        assertEquals(1, new Solution().solution2(A));
    }

    @Test
    public void testEmpty1() {
        int[] A = {};
        assertEquals(0, new Solution().solution2(A));
    }

    @Test
    public void testEmpty2() {
        int[] A = {,};
        assertEquals(0, new Solution().solution2(A));
    }

    @Test
    public void testlarge1() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i - 5000;
        }
        assertEquals(1, new Solution().solution2(A));
    }

    @Test
    public void testlarge2() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = 100000 - i;
        }
        assertEquals(1, new Solution().solution2(A));
    }

}
