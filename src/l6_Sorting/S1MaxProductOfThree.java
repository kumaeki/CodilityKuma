package l6_Sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class S1MaxProductOfThree {
    public int solution(int[] A) {
        int len = A.length;
        if (len == 3) {
            return A[0] * A[1] * A[2];
        } else if (len == 4 || len == 5) {
            Integer triplet = null;
            for (int i = 0; i < len - 2; i++) {
                for (int j = i + 1; j < len - 1; j++) {
                    for (int k = j + 1; k < len; k++) {
                        int tripletInner = A[i] * A[j] * A[k];
                        if (triplet == null || tripletInner > triplet) {
                            triplet = tripletInner;
                        }
                    }
                }
            }
            return triplet;
        } else {
            int[] sortedA = new int[6];
            // find min 3
            for (int i = 0; i < 3; i++) {
                int temp = 0;
                for (int j = len - 1; j > i; j--) {
                    if (A[j - 1] > A[j]) {
                        temp = A[j];
                        A[j] = A[j - 1];
                        A[j - 1] = temp;
                    }
                }
                sortedA[i] = A[i];
            }

            // find max 3
            for (int i = 0; i < 3; i++) {
                int temp = 0;
                for (int j = 0; j < len - 1 - i; j++) {
                    if (A[j] > A[j + 1]) {
                        temp = A[j];
                        A[j] = A[j + 1];
                        A[j + 1] = temp;
                    }
                }
                sortedA[6 - 1 - i] = A[len - 1 - i];
            }

            // {-X,-X,-X,-X,-X,0}
            if (sortedA[5] == 0) {
                return 0;
            }
            // {-X,-X,-X,-X,-X OR 0,+X}
            else if (sortedA[5] > 0 && sortedA[4] <= 0) {
                return sortedA[0] * sortedA[1] * sortedA[5];
            }
            // {-X,-X,-X,-X OR 0,+X,+X}
            else if (sortedA[4] > 0 && sortedA[3] <= 0) {
                return sortedA[0] * sortedA[1] * sortedA[5];
            }
            // {-X,-X,-X OR 0,+X,+X,+X}
            else if (sortedA[3] > 0 && sortedA[2] <= 0) {
                int maxL = sortedA[0] * sortedA[1] * sortedA[5];
                int maxR = sortedA[3] * sortedA[4] * sortedA[5];
                if (maxL > maxR) {
                    return maxL;
                } else {
                    return maxR;
                }
            } // {-X,-X,+ X,+X,+X,+X}
            else if (sortedA[2] > 0 && sortedA[1] < 0) {
                int maxL = sortedA[0] * sortedA[1] * sortedA[5];
                int maxR = sortedA[3] * sortedA[4] * sortedA[5];
                if (maxL > maxR) {
                    return maxL;
                } else {
                    return maxR;
                }
            } else {
                return sortedA[3] * sortedA[4] * sortedA[5];
            }

        }
    }

    // optimized`
    public int solution2(int[] A) {
        int len = A.length;
        // min 2 and max 3
        Integer[] sA = new Integer[5];
        for (int i = 0; i < len; i++) {
            // find min 2
            if (sA[0] == null || A[i] < sA[0]) {
                sA[1] = sA[0];
                sA[0] = A[i];
            } else if (sA[1] == null || A[i] < sA[1]) {
                sA[1] = A[i];
            }
            // find max 3
            if (sA[4] == null || A[i] > sA[4]) {
                sA[2] = sA[3];
                sA[3] = sA[4];
                sA[4] = A[i];
            } else if (sA[3] == null || A[i] > sA[3]) {
                sA[2] = sA[3];
                sA[3] = A[i];
            } else if (sA[2] == null || A[i] > sA[2]) {
                sA[2] = A[i];
            }
        }
        int triple1 = sA[0] * sA[1] * sA[4];
        int triple2 = sA[2] * sA[3] * sA[4];
        return triple1 > triple2 ? triple1 : triple2;
    }

    @Test
    public void testExample() {
        int[] A = { -3, 1, 2, -2, 5, 6 };
        assertEquals(60, new S1MaxProductOfThree().solution2(A));
    }

    @Test
    public void test3() {
        int[] A = { 1, 2, 3 };
        assertEquals(6, new S1MaxProductOfThree().solution2(A));
    }

    @Test
    public void test4_1() {
        int[] A = { 1, 2, 3, 4 };
        assertEquals(24, new S1MaxProductOfThree().solution2(A));
    }

    @Test
    public void test4_2() {
        int[] A = { 1, 2, -3, 4 };
        assertEquals(8, new S1MaxProductOfThree().solution2(A));
    }

    @Test
    public void test5_1() {
        int[] A = { 1, 2, -3, 4, -10 };
        assertEquals(120, new S1MaxProductOfThree().solution2(A));
    }

    @Test
    public void test5_2() {
        int[] A = { 1, 2, -3, 4, 0 };
        assertEquals(8, new S1MaxProductOfThree().solution2(A));
    }

    @Test
    public void test10_1() {
        int[] A = { 1, -2, 3, -4, 5, 6, -7, 8, -9, 10 };
        assertEquals(630, new S1MaxProductOfThree().solution2(A));
    }

    @Test
    public void test10_2() {
        int[] A = { -10, -8, 1, 2, 3, 4, 5, 6, 7, 8 };
        assertEquals(640, new S1MaxProductOfThree().solution2(A));
    }
}
