package lesson10.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * * A non-empty array A consisting of N integers is given. <br/>
 * <br/>
 * A peak is an array element which is larger than its neighbors. More
 * precisely, it is an index P such that 0 < P < N − 1, A[P − 1] < A[P] and A[P]
 * > A[P + 1]. <br/>
 * <br/>
 * For example, the following array A: <br/>
 * <br/>
 * A[0] = 1 <br/>
 * A[1] = 2 <br/>
 * A[2] = 3 <br/>
 * A[3] = 4 <br/>
 * A[4] = 3 <br/>
 * A[5] = 4 <br/>
 * A[6] = 1 <br/>
 * A[7] = 2 <br/>
 * A[8] = 3 <br/>
 * A[9] = 4 <br/>
 * A[10] = 6 <br/>
 * A[11] = 2 <br/>
 * has exactly three peaks: 3, 5, 10. <br/>
 * <br/>
 * We want to divide this array into blocks containing the same number of
 * elements. More precisely, we want to choose a number K that will yield the
 * following blocks: <br/>
 * <br/>
 * A[0], A[1], ..., A[K − 1], <br/>
 * A[K], A[K + 1], ..., A[2K − 1], <br/>
 * ... <br/>
 * A[N − K], A[N − K + 1], ..., A[N − 1]. <br/>
 * What's more, every block should contain at least one peak. Notice that
 * extreme elements of the blocks (for example A[K − 1] or A[K]) can also be
 * peaks, but only if they have both neighbors (including one in an adjacent
 * blocks). <br/>
 * <br/>
 * The goal is to find the maximum number of blocks into which the array A can
 * be divided. <br/>
 * <br/>
 * Array A can be divided into blocks as follows: <br/>
 * <br/>
 * one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three
 * peaks. <br/>
 * two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
 * <br/>
 * three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a
 * peak. Notice in particular that the first block (1, 2, 3, 4) has a peak at
 * A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
 * <br/>
 * However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4),
 * (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain a peak.
 * Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and
 * A[5]. <br/>
 * <br/>
 * The maximum number of blocks that array A can be divided into is three. <br/>
 * <br/>
 * Write a function: <br/>
 * <br/>
 * class Solution { public int solution(int[] A); } <br/>
 * <br/>
 * that, given a non-empty array A consisting of N integers, returns the maximum
 * number of blocks into which A can be divided. <br/>
 * <br/>
 * If A cannot be divided into some number of blocks, the function should return
 * 0. <br/>
 * <br/>
 * For example, given: <br/>
 * <br/>
 * A[0] = 1 <br/>
 * A[1] = 2 <br/>
 * A[2] = 3 <br/>
 * A[3] = 4 <br/>
 * A[4] = 3 <br/>
 * A[5] = 4 <br/>
 * A[6] = 1 <br/>
 * A[7] = 2 <br/>
 * A[8] = 3 <br/>
 * A[9] = 4 <br/>
 * A[10] = 6 <br/>
 * A[11] = 2 <br/>
 * the function should return 3, as explained above. <br/>
 * <br/>
 * Write an efficient algorithm for the following assumptions: <br/>
 * <br/>
 * N is an integer within the range [1..100,000]; <br/>
 * each element of array A is an integer within the range [0..1,000,000,000].
 * <br/>
 * Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized
 * copying, publication or disclosure prohibited. <br/>
 * 
 */
public class Solution {
    public int solution(int[] A) {

        int len = A.length;
        if (len < 3) {
            return 0;
        }

        int[] pa = new int[len];
        for (int i = 1; i < len - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                pa[i] = pa[i - 1] + 1;
            } else {
                pa[i] = pa[i - 1];
            }
        }
        pa[len - 1] = pa[len - 2];

        // get divisors
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        divisors.add(len);
        double s = Math.sqrt(len);
        for (int i = 2; i <= s; i++) {
            if (len % i == 0) {
                if (i == s) {
                    divisors.add(i);
                } else {
                    divisors.add(len / i);
                    divisors.add(i);
                }
            }
        }

        // descend sort
        divisors.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        int max = 0;
        for (int d : divisors) {
            boolean isPeakExist = true;
            for (int i = 0; i < len; i = i + d) {
                if (i == 0) {
                    if (pa[i + d - 1] == 0) {
                        isPeakExist = false;
                        break;
                    }
                } else {
                    if (pa[i + d - 1] - pa[i - 1] <= 0) {
                        isPeakExist = false;
                        break;
                    }
                }
            }
            if (isPeakExist) {
                max = len / d;
            }
        }

        return max;
    }

    @Test
    public void testExample() {
        int A[] = { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
        assertEquals(3, new Solution().solution(A));
    }

    @Test
    public void testFour1() {
        int A[] = { 1, 3, 2, 1 };
        assertEquals(1, new Solution().solution(A));
    }

    @Test
    public void testFour2() {
        int A[] = { 1, 1, 1, 1, 1 };
        assertEquals(0, new Solution().solution(A));
    }

    @Test
    public void testSimple1() {
        int A[] = { 1, 2, 3, 2, 1, 2, 1, 3, 2, 3, 2, 1 };
        assertEquals(4, new Solution().solution(A));
    }
}
