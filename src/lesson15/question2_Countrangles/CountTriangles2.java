package lesson15.question2_Countrangles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/**
 * to slow
 * 
 * @author xiong_yi
 *
 */
public class CountTriangles2 {
    public int solution(int[] A) {
        int max = getMax(A);
        int[] valArr = new int[max + 1];
        for (int a : A) {
            valArr[a]++;
        }

        int[] arr = new int[A.length];
        int index = 0;
        for (int i = 0; i < max + 1; i++) {
            while (valArr[i] != 0) {
                arr[index] = i;
                index++;
                valArr[i]--;
            }
        }

        // sort A
        int len = A.length;

        int result = 0;
        int i = 0;
        int j = 1;
        int k = 2;
        for (; i < len - 2; i++) {
            for (j = i + 1; j < len - 1; j++) {
                for (k = j + 1; k < len && arr[i] + arr[j] > arr[k]; k++) {
                }
                result += (k - 1 - j);
            }

        }

        return result;
    }

    int getMax(int[] A) {
        int max = 0;
        for (int a : A) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    @Test
    public void testExample() {
        int[] A = { 10, 2, 5, 1, 8, 12 };
        int result = 4;
        assertEquals(result, new CountTriangles2().solution(A));

    }
}
