package lesson91_2016Challenge.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DwarfsRafting {

    final static int LEFT = 0;
    final static int RIGHT = 1;
    final static int FRONT = 2;
    final static int BACK = 3;

    public int solution(int N, String S, String T) {
        int len = N / 2;

        // { space , weight }
        int[] front_left = { len * len, 0 };
        int[] front_right = { len * len, 0 };
        int[] back_left = { len * len, 0 };
        int[] back_right = { len * len, 0 };

        // barrels's position
        for (String s : S.split(" ")) {
            if (s.isEmpty()) {
                continue;
            }
            int row;
            int column;
            if (s.length() == 3) {
                row = Integer.valueOf(s.substring(0, 2));
                column = Integer.valueOf(s.toCharArray()[2]);
            } else {
                row = Integer.valueOf(s.substring(0, 1));
                column = Integer.valueOf(s.toCharArray()[1]);
            }
            int row_position = judgePositionFB(row, N);
            int column_position = judgePositionLR(column, N);
            if (row_position == FRONT) {
                if (column_position == LEFT) {
                    front_left[0]--;
                } else if (column_position == RIGHT) {
                    front_right[0]--;
                }
            } else if (row_position == BACK) {
                if (column_position == LEFT) {
                    back_left[0]--;
                } else if (column_position == RIGHT) {
                    back_right[0]--;
                }
            }
        }

        // occupied position
        for (String s : T.split(" ")) {
            if (s.isEmpty()) {
                continue;
            }
            int row;
            int column;
            if (s.length() == 3) {
                row = Integer.valueOf(s.substring(0, 2));
                column = Integer.valueOf(s.toCharArray()[2]);
            } else {
                row = Integer.valueOf(s.substring(0, 1));
                column = Integer.valueOf(s.toCharArray()[1]);
            }
            int row_position = judgePositionFB(row, N);
            int column_position = judgePositionLR(column, N);
            if (row_position == FRONT) {
                if (column_position == LEFT) {
                    front_left[0]--;
                    front_left[1]++;
                } else if (column_position == RIGHT) {
                    front_right[0]--;
                    front_right[1]++;
                }
            } else if (row_position == BACK) {
                if (column_position == LEFT) {
                    back_left[0]--;
                    back_left[1]++;
                } else if (column_position == RIGHT) {
                    back_right[0]--;
                    back_right[1]++;
                }
            }
        }

        int max1 = getMax(front_left, back_right);
        if (max1 == -1)
            return -1;

        int max2 = getMax(front_right, back_left);
        if (max2 == -1)
            return -1;

        return max1 + max2;
    }

    /**
     * Front or back or enter?
     * 
     */
    int judgePositionFB(int row, int n) {
        if (row <= n / 2) {
            return FRONT;
        } else {
            return BACK;
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
            return RIGHT;
        }
    }

    int getMax(int[] part1, int[] part2) {
        if (part1[1] < part2[1]) {
            return getMax(part2, part1);
        }
        int diff = part1[1] - part2[1];
        if (diff > part2[0])
            return -1;

        return diff + 2 * Math.min(part1[0], part2[0] - diff);
    }

    @Test
    public void testExample1() {
        int N = 4;
        String S = "1B 1C 4B 1D 2A";
        String T = "3B 2D";
        int result = 6;
        assertEquals(result, new DwarfsRafting().solution(N, S, T));
    }

}
