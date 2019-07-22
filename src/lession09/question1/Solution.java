package lession09.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Solution {
    public int solution(int[] A) {

        int len = A.length;
        if (len < 2) {
            return 0;
        }

        int max = 0;
        int min = A[0];
        for (int i = 1; i < len; i++) {
            int a = A[i];
            min = a < min ? a : min;
            max = a - min > max ? a - min : max;
        }
        if (max > 0)
            return max;
        else
            return 0;
    }

    @Test
    public void testExample() {
        int[] A = { 23171, 21011, 21123, 21366, 21013, 21367 };
        assertEquals(356, new Solution().solution(A));
    }
}
