package lesson10.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    public int solution(int N) {
        int result = 0;
        int index = 1;
        double s = Math.sqrt(N);
        while (index  < s) {
            if (N % index == 0)
                result += 2;
            index++;
        }
        if (index * index == N)
            result++;
        return result;
    }

    @Test
    public void testExample() {
        int A = 24;
        assertEquals(8, new Solution().solution(A));
    }

    @Test
    public void testBig2() {
        int A = 2147395600;
        assertEquals(135, new Solution().solution(A));
    }

}
