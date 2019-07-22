package lesson10.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**

 * 
 * 
 * 
 * 
 *
 */
public class Solution {
    public int solution(int N) {

        int rectangle = 2 * (N + 1);
        int result = rectangle;
        double s = Math.sqrt(N);
        int i = 1;
        while (i <= s) {
            if (N % i == 0) {
                rectangle = 2 * (i + N / i);
                if (result > rectangle) {
                    result = rectangle;
                }
            }
            i++;
        }
        return result;
    }

    @Test
    public void testExample() {
        int A = 30;
        assertEquals(22, new Solution().solution(A));
    }

    @Test
    public void testSmall() {
        int A = 1;
        assertEquals(4, new Solution().solution(A));
    }
}
