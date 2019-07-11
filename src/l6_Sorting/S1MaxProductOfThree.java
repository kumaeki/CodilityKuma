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
                        if (triplet == null || tripletInner < triplet) {
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
                for (int j = i + 1; j < len - 1; j++) {
                    if (A[j + 1] < A[j]) {
                        temp = A[j];
                        A[j] = A[j + 1];
                        A[j + 1] = temp;
                    }
                }
                sortedA[i] = A[i];
            }

            // find max 3
            for (int i = 0; i < 3; i++) {
                int max = A[i];
                for (int j = i + 1; j < len; j++) {
                    if (A[j] > max) {
                        max = A[j];
                    }
                }
                sortedA[6 - 1 - i] = max;
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
            } else {
                return sortedA[3] * sortedA[4] * sortedA[5];
            }

        }
    }

    @Test
    public void testExample() {
        int[] A = { -3, 1, 2, -2, 5, 6 };
        assertEquals(60, new S1MaxProductOfThree().solution(A));
    }

    @Test
    public void test3() {
        int[] A = { 1, 2, 3 };
        assertEquals(6, new S1MaxProductOfThree().solution(A));
    }

    @Test
    public void test4_1() {
        int[] A = { 1, 2, 3, 4 };
        assertEquals(24, new S1MaxProductOfThree().solution(A));
    }

    @Test
    public void test4_2() {
        int[] A = { 1, 2, -3, 4 };
        assertEquals(8, new S1MaxProductOfThree().solution(A));
    }

    @Test
    public void test5_1() {
        int[] A = { 1, 2, -3, 4, -10 };
        assertEquals(8, new S1MaxProductOfThree().solution(A));
    }

    @Test
    public void test5_2() {
        int[] A = { 1, 2, -3, 4, 0 };
        assertEquals(8, new S1MaxProductOfThree().solution(A));
    }
}
