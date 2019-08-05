package lesson15.question4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author xiong_yi
 *
 */
public class MinAbsSumOfTwo3 {
    public int solution(int[] A) {
        int result = -1;
        // sort the Array
        int len = A.length;
        if (len == 1) {
            return Math.abs(2 * A[0]);
        }

        // positive list
        ArrayList<Integer> posList = new ArrayList<Integer>(len);
        // negative list
        ArrayList<Integer> negList = new ArrayList<Integer>(len);
        for (int a : A) {
            if (a == 0) {
                return 0;
            } else if (a > 0) {
                posList.add(a);
            } else {
                negList.add(a);
            }
        }

        Collections.sort(posList);
        Collections.sort(negList);
        // if all the elements are smaller than 0
        if (posList.size() == 0) {
            return Math.abs(2 * negList.get(negList.size() - 1));
        }
        // if all the elements are bigger than 0
        if (negList.size() == 0) {
            return 2 * posList.get(0);
        }

        int minabs = Math.min(Math.abs(2 * negList.get(negList.size() - 1)), 2 * posList.get(0));

        int end = posList.size() - 1;
        for (int neg : negList) {
            int abs = 0 - neg;
            int start = 0;
            int candidateIndex = 0;
            while (start <= end) {
                int middle = (start + end) / 2;
                candidateIndex = middle;
                if (abs == posList.get(middle)) {
                    return 0;
                } else if (abs < posList.get(middle)) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            int temp = Math.abs(neg + posList.get(candidateIndex));
            temp = candidateIndex == 0 ? temp : Math.min(temp, Math.abs(neg + posList.get(candidateIndex - 1)));
            result = result == -1 ? temp : Math.min(result, temp);
            
            end = candidateIndex;
        }
        return Math.min(result, minabs);
    }

    @Test
    public void TestExample1() {
        int[] A = { 1, 4, -3 };
        int result = 1;
        assertEquals(result, new MinAbsSumOfTwo3().solution(A));
    }

    @Test
    public void TestExample2() {
        int[] A = { -8, 4, 5, -10, 3 };
        int result = 3;
        assertEquals(result, new MinAbsSumOfTwo3().solution(A));
    }

    @Test
    public void TestSimple1() {
        int[] A = { 1, 4, 0, 5 };
        int result = 0;
        assertEquals(result, new MinAbsSumOfTwo3().solution(A));
    }

    @Test
    public void TestSimple2() {
        int[] A = { 1, 4, 100, 5 };
        int result = 2;
        assertEquals(result, new MinAbsSumOfTwo3().solution(A));
    }

    @Test
    public void TestSimple3() {
        int[] A = { -1, -4, -100, -5 };
        int result = 2;
        assertEquals(result, new MinAbsSumOfTwo3().solution(A));
    }

    @Test
    public void TestSimple4() {
        int[] A = { -1, -4, 0, -100, -5 };
        int result = 0;
        assertEquals(result, new MinAbsSumOfTwo3().solution(A));
    }

    @Test
    public void TestSimple5() {
        int[] A = { 0 };
        int result = 0;
        assertEquals(result, new MinAbsSumOfTwo3().solution(A));
    }

    @Test
    public void TestSimple6() {
        int[] A = { 100 };
        int result = 200;
        assertEquals(result, new MinAbsSumOfTwo3().solution(A));
    }

    @Test
    public void TestSimple7() {
        int[] A = { -100, -1, 201, 105, 95 };
        int result = 2;
        assertEquals(result, new MinAbsSumOfTwo3().solution(A));
    }

    @Test
    public void TestSimple8() {
        int[] A = { -100, 2, 201, 105, 95 };
        int result = 4;
        assertEquals(result, new MinAbsSumOfTwo3().solution(A));
    }

}
