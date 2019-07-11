package l5_PrefixSums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class S5CountDiv {
    public int solution(int A, int B, int K) {
        int result = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                result++;
            }
        }

        return result;
    }

    public int solution1(int A, int B, int K) {
        int min = A;
        int count = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                count++;
                min = i;
                break;
            }
        }
        count += (B - min) / K;
        return count;
    }

    @Test
    public void testExample() {
        int A = 6;
        int B = 11;
        int K = 2;
        assertEquals(3, new S5CountDiv().solution1(A, B, K));
    }

    @Test
    public void testLarge() {
        int A = 6;
        int B = 1100000;
        int K = 3;
        S5CountDiv countDiv = new S5CountDiv();
        assertEquals(countDiv.solution(A, B, K), countDiv.solution1(A, B, K));
    }
    
    @Test
    public void testSmall() {
        int A = 10;
        int B = 10;
        int K = 20;
        S5CountDiv countDiv = new S5CountDiv();
        assertEquals(countDiv.solution(A, B, K), countDiv.solution1(A, B, K));
    }

}
