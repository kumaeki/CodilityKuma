package lession04_CountingElements.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PermCheck1 {
    public int solution(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        for (int a : A) {
            if (a > len) {
                return 0;
            } else {
                B[a - 1] = a;
            }
        }
        for (int b : B) {
            if (b == 0) {
                return 0;
            }
        }
        return 1;
    }

    @Test
    public void testExample1() {
        int[] A = { 4, 1, 3, 2 };
        int result = 1;
        assertEquals(result, new PermCheck1().solution(A));
    }

    @Test
    public void testExample2() {
        int[] A = { 4, 1, 3 };
        int result = 0;
        assertEquals(result, new PermCheck1().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = { 1 };
        int result = 1;
        assertEquals(result, new PermCheck1().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 2 };
        int result = 0;
        assertEquals(result, new PermCheck1().solution(A));
    }

    @Test
    public void testSimple3() {
        int[] A = { 1, 2, 2, 2, 2, 2 };
        int result = 0;
        assertEquals(result, new PermCheck1().solution(A));
    }

}
