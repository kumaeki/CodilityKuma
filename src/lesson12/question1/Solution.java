package lesson12.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * 
 * ChocolatesByNumbers <br/>
 * There are N chocolates in a circle. Count the number of chocolates you will eat.
 * 
 * *Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle,
 * numbered from 0 to N − 1.<br/>
 * You start to eat the chocolates. After eating a chocolate you leave only a wrapper.<br/>
 * You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat
 * the following one.<br/>
 * More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N
 * (remainder of division).<br/>
 * You stop eating when you encounter an empty wrapper.<br/>
 * For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.<br/>
 * The goal is to count the number of chocolates that you will eat, following the above rules.<br/>
 * Write a function:<br/>
 * class Solution { public int solution(int N, int M); }<br/>
 * that, given two positive integers N and M, returns the number of chocolates that you will eat.<br/>
 * For example, given integers N = 10 and M = 4. the function should return 5, as explained above.<br/>
 * Write an efficient algorithm for the following assumptions:<br/>
 * N and M are integers within the range [1..1,000,000,000].<br/>
 * Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure
 * prohibited.<br/>
 * 
 * 
 * @author tedyi
 *
 */
public class Solution {

    public int solution(int N, int M) {

        // greatest common divisor
        int gcd = 1;
        int res = 1;
        int n = N;
        int m = M;
        while (n != m) {
            if (n % 2 == 0 && m % 2 == 0) {
                n /= 2;
                m /= 2;
                res *= 2;
            } else if (n % 2 == 0) {
                n /= 2;
            } else if (m % 2 == 0) {
                m /= 2;
            } else if (n > m) {
                n = n - m;
            } else {
                m = m - n;
            }
        }
        gcd = res * n;

        return N / gcd;
    }

    @Test
    public void testExample() {
        int N = 10;
        int M = 4;
        int result = 5;
        assertEquals(result, new Solution().solution(N, M));
    }

    @Test
    public void testsmall1() {
        int N = 2;
        int M = 3;
        int result = 2;
        assertEquals(result, new Solution().solution(N, M));
    }

    @Test
    public void testsmall2() {
        int N = 2;
        int M = 1;
        int result = 2;
        assertEquals(result, new Solution().solution(N, M));
    }

    @Test
    public void testsmall3() {
        int N = 2;
        int M = 2;
        int result = 1;
        assertEquals(result, new Solution().solution(N, M));
    }

    @Test
    public void testLarge1() {
        int N = 1000000000;
        int M = 2;
        int result = 500000000;
        assertEquals(result, new Solution().solution(N, M));
    }

    @Test
    public void testLarge2() {
        int N = 1000000000;
        int M = 999999999;
        int result = 1000000000;
        assertEquals(result, new Solution().solution(N, M));
    }
}
