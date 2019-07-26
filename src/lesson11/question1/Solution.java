package lesson11.question1;

import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        int len = P.length;
        int[] minFactor = getMinFactor(N);
        int[] countArr = getFactorCountArr(minFactor);
        int[] semiFactorArr = getSemiFactorArr(countArr);
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int p = P[i] - 1;
            int q = Q[i] - 1;
            if (p > 1) {
                p--;
            }
            result[i] = semiFactorArr[q] - semiFactorArr[p];
        }
        return result;
    }

    /**
     * get the number of semifactor
     * 
     */
    int[] getSemiFactorArr(int[] factorCountArr) {
        int len = factorCountArr.length;
        int[] semiFactorArr = new int[len];
        for (int i = 1; i < len; i++) {
            if (factorCountArr[i] == 2) {
                semiFactorArr[i] = semiFactorArr[i - 1] + 1;
            } else {
                semiFactorArr[i] = semiFactorArr[i - 1];
            }
        }
        return semiFactorArr;
    }

    /**
     * get the number of prime factor
     * 
     */
    int[] getFactorCountArr(int[] minFactorArr) {
        int len = minFactorArr.length;
        int[] countArr = new int[len];
        for (int index = 3; index < len; index++) {
            int j = index + 1;
            while (minFactorArr[j - 1] > 0) {
                j = j / minFactorArr[j - 1];
                countArr[index]++;
            }
            if (countArr[index] > 0)
                countArr[index]++;
        }
        return countArr;
    }

    /**
     * get mininum prime factor
     * 
     */
    int[] getMinFactor(int N) {
        int[] result = new int[N];
        int sqrt = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrt; i++) {
            if (result[i - 1] == 0) {
                int k = i * i;
                while (k <= N) {
                    if (result[k - 1] == 0) {
                        result[k - 1] = i;
                    }
                    k += i;
                }
            }
        }
        return result;
    }

    @Test
    public void testExample() {
        int N = 26;
        int[] P = { 1, 4, 16 };
        int[] Q = { 26, 10, 20 };
        int[] result = { 10, 4, 0 };
        assertArrayEquals(result, new Solution().solution(N, P, Q));
    }

    @Test
    public void testSingle() {
        int N = 1;
        int[] P = { 1 };
        int[] Q = { 1 };
        int[] result = { 0 };
        assertArrayEquals(result, new Solution().solution(N, P, Q));
    }

    @Test
    public void testDouble() {
        int N = 2;
        int[] P = { 1, 1 };
        int[] Q = { 1, 2 };
        int[] result = { 0, 0 };
        assertArrayEquals(result, new Solution().solution(N, P, Q));
    }

    @Test
    public void testThree() {
        int N = 3;
        int[] P = { 1, 1, 1 };
        int[] Q = { 1, 2, 3 };
        int[] result = { 0, 0, 0 };
        assertArrayEquals(result, new Solution().solution(N, P, Q));
    }

    @Test
    public void testFour() {
        int N = 4;
        int[] P = { 1, 1, 3, 4 };
        int[] Q = { 1, 2, 4, 4 };
        int[] result = { 0, 0, 1, 1 };
        assertArrayEquals(result, new Solution().solution(N, P, Q));
    }

    @Test
    public void testLarge() {
        int N = 50000;
        int[] P = { 1, 4, 16 };
        int[] Q = { 26, 10, 20 };
        int[] result = { 10, 4, 0 };
        assertArrayEquals(result, new Solution().solution(N, P, Q));
    }

}
