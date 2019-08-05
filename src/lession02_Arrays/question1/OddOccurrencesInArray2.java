package lession02_Arrays.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OddOccurrencesInArray2 {

    public int solution(int[] A) {
        int result = 0;
        for (int a : A) {
            result ^= a;
        }
        return result;
    }

    @Test
    public void test0() {
        int[] in = { 9, 3, 9, 3, 9, 7, 9 };
        int out = 7;
        assertEquals(out, solution(in));
    }

    @Test
    public void test1() {
        int[] in = { 1, 2, 3, 1, 2, 3, 4 };
        int out = 4;
        assertEquals(out, solution(in));
    }

    @Test
    public void test2() {
        int[] in = { 3 };
        int out = 3;
        assertEquals(out, solution(in));
    }
}
