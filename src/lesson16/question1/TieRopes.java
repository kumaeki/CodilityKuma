package lesson16.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TieRopes {
        public int solution(int K, int[] A) {
            int count = 0;
            int sum = 0;
            for (int a : A) {
                sum += a;
                if (sum >= K) {
                    count++;
                    sum = 0;
                }
            }
            return count;
        }

    @Test
    public void testExample() {
        int K = 4;
        int[] A = { 1, 2, 3, 4, 1, 1, 3 };
        int result = 3;
        assertEquals(result, new TieRopes().solution(K, A));
    }

    @Test
    public void testSimple1() {
        int K = 4;
        int[] A = { 1 };
        int result = 0;
        assertEquals(result, new TieRopes().solution(K, A));
    }

    @Test
    public void testSimple2() {
        int K = 1;
        int[] A = { 1, 2, 3, 4, 5, 6 };
        int result = 6;
        assertEquals(result, new TieRopes().solution(K, A));
    }
}
