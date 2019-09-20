package lesson91_2016Challenge.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RectangleBuilderGreaterArea1 {
    public int solution(int[] A, int X) {
        int n = A.length;
        if (n < 4) {
            return 0;
        }
        List<int[]> list = new ArrayList<int[]>();
        Arrays.parallelSort(A);

        int[] tempPieces = new int[] { A[0], 1 };

        // get pieces which counts >= 2
        for (int i = 1; i < n; i++) {
            int cur = A[i];
            if (tempPieces[0] == cur) {
                tempPieces[1]++;
            } else {
                if (tempPieces[1] > 1) {
                    list.add(tempPieces.clone());
                }
                tempPieces[0] = A[i];
                tempPieces[1] = 1;
            }
        }
        if (tempPieces[1] > 1) {
            list.add(tempPieces);
        }

        int sum = 0;
        int s = list.size();
        for (int i = 0; i < s; i++) {
            int[] leftPiece = list.get(i);
            int leftPieceLen = leftPiece[0];
            int leftPieceCount = leftPiece[1];
            if (leftPieceCount > 3 && isProductBigger(leftPieceLen, leftPieceLen, X) >= 0) {
                sum += (s - i);
            } else {
                // binary search
                int start = i + 1;
                int end = s - 1;
                int middle = (start + end) / 2;
                boolean isSame = false;
                while (start <= end) {
                    middle = (start + end) / 2;
                    int rightPicecLen = list.get(middle)[0];
                    int compareResult = isProductBigger(leftPieceLen, rightPicecLen, X);
                    if (compareResult > 0) {
                        end = middle - 1;
                    } else if (compareResult < 0) {
                        start = middle + 1;
                    } else {
                        isSame = true;
                        break;
                    }
                }
                int count = 0;
                if (isSame) {
                    count = s - middle;
                } else {
                    count = Math.max(s - start, 0);
                }
                sum += count;

                if (sum > 1000000000) {
                    return -1;
                }
            }
        }
        return sum;
    }

    int isProductBigger(int arg1, int arg2, int target) {
        double d = arg1 * (double) arg2;
        return Double.compare(d, target);
    }

    @Test
    public void tetExample() {
        int[] A = { 1, 2, 5, 1, 1, 2, 3, 5, 1, 1, 1, 1, 1, 1, 1 };
        int X = 5;
        int result = 2;
        assertEquals(result, new RectangleBuilderGreaterArea1().solution(A, X));
    }

    @Test
    public void tetSimple1() {
        int[] A = { 1 };
        int X = 5;
        int result = 0;
        assertEquals(result, new RectangleBuilderGreaterArea1().solution(A, X));
    }

    @Test
    public void tetSimple2() {
        int[] A = { 1, 2 };
        int X = 5;
        int result = 0;
        assertEquals(result, new RectangleBuilderGreaterArea1().solution(A, X));
    }

    @Test
    public void tetSimple3() {
        int[] A = { 1, 2, 1, 2 };
        int X = 5;
        int result = 0;
        assertEquals(result, new RectangleBuilderGreaterArea1().solution(A, X));
    }

    @Test
    public void tetSimple4() {
        int[] A = { 1, 2, 1, 2 };
        int X = 1;
        int result = 1;
        assertEquals(result, new RectangleBuilderGreaterArea1().solution(A, X));
    }

    @Test
    public void tetSimple5() {
        int[] A = { 1, 2, 1, 2, 1, 2, 1, 2 };
        int X = 1;
        int result = 3;
        assertEquals(result, new RectangleBuilderGreaterArea1().solution(A, X));
    }
}
