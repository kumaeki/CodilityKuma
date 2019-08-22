package lession06_Sorting.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class Distinct1 {
    public int solution(int[] A) {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int a : A) {
            s.add(a);
        }
        return s.size();
    }

    @Test
    public void testExample() {
        int[] A = { 2, 1, 1, 2, 3, 1 };
        int result = 3;
        assertEquals(result, new Distinct1().solution(A));
    }

    @Test
    public void testSimple1() {
        int[] A = {};
        int result = 0;
        assertEquals(result, new Distinct1().solution(A));
    }

    @Test
    public void testSimple2() {
        int[] A = { 1 };
        int result = 1;
        assertEquals(result, new Distinct1().solution(A));
    }

}
