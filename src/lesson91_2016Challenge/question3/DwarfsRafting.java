package lesson91_2016Challenge.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DwarfsRafting {

    final static int LEFT = 0;
    final static int RIGHT = 1;
    final static int MIDDLE = 2;

    final static int FRONT = 3;
    final static int BACK = 4;
    final static int CENTER = 5;

    public int solution(int N, String S, String T) {
        int len = N / 2;
        int size_front_left = len * len;
        int weight_front_left = 0;
        int size_front_right = len * len;
        int weight_front_right = 0;
        int size_back_left = len * len;
        int weight_back_left = 0;
        int size_back_right = len * len;
        int weight_back_right = 0;
        int weight_middle = 0;

        // barrels's position
        for (String s : S.split(" ")) {
            int row = Integer.valueOf(s.substring(0, 1));
            int column = Integer.valueOf(s.toCharArray()[0]);
            int row_position = judgePositionFB(row, N);
            int column_position = judgePositionLR(column, N);
            if (row_position == FRONT && column_position == LEFT) {
                size_front_left--;
            } else if (row_position == FRONT && column_position == RIGHT) {
                size_front_right--;
            } else if (row_position == BACK && column_position == LEFT) {
                size_back_left--;
            } else if (row_position == BACK && column_position == RIGHT) {
                size_back_right--;
            }
        }

        // occupied position
        for (String s : T.split(" ")) {
            int row = Integer.valueOf(s.substring(0, 1));
            int column = Integer.valueOf(s.toCharArray()[0]);
            int row_position = judgePositionFB(row, N);
            int column_position = judgePositionLR(column, N);
            if (row_position == FRONT && column_position == LEFT) {
                size_front_left--;
                weight_front_left++;
            } else if (row_position == FRONT && column_position == RIGHT) {
                size_front_right--;
                weight_front_right++;
            } else if (row_position == BACK && column_position == LEFT) {
                size_back_left--;
                weight_back_left++;
            } else if (row_position == BACK && column_position == RIGHT) {
                size_back_right--;
                weight_back_right++;
            } else {
                weight_middle++;
            }
        }

        return -1;
    }

    /**
     * Front or back or enter?
     * 
     */
    int judgePositionFB(int row, int n) {
        if (row <= n / 2) {
            return FRONT;
        } else {
            if (n % 2 == 0) {
                return BACK;
            } else {
                if (row == n / 2 + 1) {
                    return CENTER;
                } else {
                    return BACK;
                }
            }
        }
    }

    /**
     * left or right or middle?
     * 
     */
    int judgePositionLR(int column, int n) {
        if (column <= 'A' + n / 2 - 1) {
            return LEFT;
        } else {
            if (n % 2 == 0) {
                return RIGHT;
            } else {
                if (column == 'A' + n / 2) {
                    return MIDDLE;
                } else {
                    return RIGHT;
                }
            }
        }
    }

    @Test
    public void testExample1() {
        int N = 4;
        String S = "1B 1C 4B 1D 2A";
        String T = "3B 2D";
        String result = "6";
        assertEquals(result, new DwarfsRafting().solution(N, S, T));
    }

    public static void main(String[] args) {
//        System.out.println(FRONT == new DwarfsRafting().judgePositionFB(1, 5));
//        System.out.println(FRONT == new DwarfsRafting().judgePositionFB(2, 5));
//        System.out.println(CENTER == new DwarfsRafting().judgePositionFB(3, 5));
//        System.out.println(BACK == new DwarfsRafting().judgePositionFB(4, 5));
//        System.out.println(BACK == new DwarfsRafting().judgePositionFB(5, 5));
//
//        System.out.println(FRONT == new DwarfsRafting().judgePositionFB(1, 6));
//        System.out.println(FRONT == new DwarfsRafting().judgePositionFB(2, 6));
//        System.out.println(FRONT == new DwarfsRafting().judgePositionFB(3, 6));
//        System.out.println(BACK == new DwarfsRafting().judgePositionFB(4, 6));
//        System.out.println(BACK == new DwarfsRafting().judgePositionFB(5, 6));
//        System.out.println(BACK == new DwarfsRafting().judgePositionFB(6, 6));

        System.out.println(LEFT == new DwarfsRafting().judgePositionLR('A', 5));
        System.out.println(LEFT == new DwarfsRafting().judgePositionLR('B', 5));
        System.out.println(MIDDLE == new DwarfsRafting().judgePositionLR('C', 5));
        System.out.println(RIGHT == new DwarfsRafting().judgePositionLR('D', 5));
        System.out.println(RIGHT == new DwarfsRafting().judgePositionLR('E', 5));

        System.out.println(LEFT == new DwarfsRafting().judgePositionLR('A', 6));
        System.out.println(LEFT == new DwarfsRafting().judgePositionLR('B', 6));
        System.out.println(LEFT == new DwarfsRafting().judgePositionLR('C', 6));
        System.out.println(RIGHT == new DwarfsRafting().judgePositionLR('D', 6));
        System.out.println(RIGHT == new DwarfsRafting().judgePositionLR('E', 6));
        System.out.println(RIGHT == new DwarfsRafting().judgePositionLR('F', 6));
    }

}
