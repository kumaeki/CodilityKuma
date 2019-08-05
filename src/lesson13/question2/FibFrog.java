package lesson13.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class FibFrog {

    public int solution(int[] A) {
        int len = A.length;
        // list of fibonacci numbers smaller than the length of A
        ArrayList<Integer> fibList = getFibList(len + 1);
        int flen = fibList.size();
        // result list
        ArrayList<int[]> resList = new ArrayList<int[]>();
        // [0] : current position
        // [1] : number of steps to current position
        resList.add(new int[] { -1, 0 });
        int index = 0;
        while (true) {
            if (index == resList.size()) {
                return -1;
            }
            int[] current = resList.get(index);
            for (int i = flen - 1; i >= 0; i--) {
                int next = current[0] + fibList.get(i);
                if (next == len) {
                    return current[1] + 1;
                } else if (next < len && A[next] == 1) {
                    resList.add(new int[] { next, current[1] + 1 });
                    A[next] = 0;
                }
            }
            index++;
        }
    }

    ArrayList<Integer> getFibList(int N) {
        ArrayList<Integer> fibList = new ArrayList<Integer>();
        fibList.add(1);
        int next = 2;
        int index = 1;
        while (next <= N) {
            fibList.add(next);
            next = fibList.get(index) + fibList.get(index - 1);
            index++;
        }
        return fibList;
    }

    @Test
    public void testExample() {
        int[] A = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
        int result = 3;
        assertEquals(result, new FibFrog().solution(A));
    }
}
