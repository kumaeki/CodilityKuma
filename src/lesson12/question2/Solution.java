package lesson12.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Solution {

    public int solution(int[] A, int[] B) {
        int len = A.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (hasSamplePrimeFactor(A[i], B[i])) {
                result++;
            }
        }
        return result;
    }

    boolean hasSamplePrimeFactor(int a, int b) {
        int gcd = getGCD(a, b);

        while (a != 1) {
            int gcdA = getGCD(a, gcd);
            if (gcdA == 1) {
                break;
            }
            a /= gcdA;
        }
        if (a != 1) {
            return false;
        }

        while (b != 1) {
            int gcdB = getGCD(b, gcd);
            if (gcdB == 1) {
                break;
            }
            b /= gcdB;
        }
        if (b != 1) {
            return false;
        }
        return true;
    }

    int getGCD(int A, int B) {
        int a = A;
        int b = B;
        int res = 1;
        while (a != b) {
            if (a % 2 == 0 && b % 2 == 0) {
                a /= 2;
                b /= 2;
                res *= 2;
            } else if (a % 2 == 0) {
                a /= 2;
            } else if (b % 2 == 0) {
                b /= 2;
            } else if (a > b) {
                a -= b;
            } else if (a < b) {
                b -= a;
            }
        }
        return a * res;
    }

    @Test
    public void testExample() {
        int[] A = { 15, 10, 3 };
        int[] B = { 75, 30, 5 };
        int result = 1;
        assertEquals(result, new Solution().solution(A, B));
    }

    @Test
    public void testSingle1() {
        int[] A = { 1 };
        int[] B = { 1 };
        int result = 1;
        assertEquals(result, new Solution().solution(A, B));
    }

    @Test
    public void testSingle2() {
        int[] A = { 1 };
        int[] B = { 2 };
        int result = 0;
        assertEquals(result, new Solution().solution(A, B));
    }

    @Test
    public void testSingle3() {
        int[] A = { 3 };
        int[] B = { 2 };
        int result = 0;
        assertEquals(result, new Solution().solution(A, B));
    }

    @Test
    public void testSingle4() {
        int[] A = { 3 };
        int[] B = { 9 };
        int result = 1;
        assertEquals(result, new Solution().solution(A, B));
    }
}
