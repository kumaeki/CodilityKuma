package lession05_PrefixSums.question4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CountDiv {
    public int solution(int A, int B, int K) {
        if (B < K) {
            return A == 0 ? 1 : 0;
        }
        int right = B;
        if (B % K != 0) {
            right = (B / K) * K;
        }
        return right < A ? 0 : (right - A) / K + 1;
    }

    @Test
    public void testExample() {
        int A = 6;
        int B = 11;
        int K = 2;
        int result = 3;
        assertEquals(result, new CountDiv().solution(A, B, K));
    }

    @Test
    public void testSimple1() {
        int A = 6;
        int B = 12;
        int K = 2;
        int result = 4;
        assertEquals(result, new CountDiv().solution(A, B, K));
    }

    @Test
    public void testSimple2() {
        int A = 7;
        int B = 13;
        int K = 2;
        int result = 3;
        assertEquals(result, new CountDiv().solution(A, B, K));
    }

    @Test
    public void testSimple3() {
        int A = 7;
        int B = 8;
        int K = 2;
        int result = 1;
        assertEquals(result, new CountDiv().solution(A, B, K));
    }

    @Test
    public void testSimple4() {
        int A = 6;
        int B = 7;
        int K = 2;
        int result = 1;
        assertEquals(result, new CountDiv().solution(A, B, K));
    }

    @Test
    public void testSimple5() {
        int A = 11;
        int B = 39;
        int K = 17;
        int result = 2;
        assertEquals(result, new CountDiv().solution(A, B, K));
    }

    @Test
    public void testSimple6() {
        int A = 1;
        int B = 1;
        int K = 11;
        int result = 0;
        assertEquals(result, new CountDiv().solution(A, B, K));
    }

    @Test
    public void testSimple7() {
        int A = 0;
        int B = 0;
        int K = 11;
        int result = 1;
        assertEquals(result, new CountDiv().solution(A, B, K));
    }
    
    @Test
    public void testSimple8() {
        int A = 0;
        int B = 14;
        int K = 2;
        int result = 8;
        assertEquals(result, new CountDiv().solution(A, B, K));
    }
}
