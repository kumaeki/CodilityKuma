package lession01_Iterations.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinaryGap2 {

    public int solution(int N) {
        char[] c = Integer.toBinaryString(N).toCharArray();
        int len = c.length;
        int result = 0;
        int pre = 0;
        for (int i = 0; i < len; i++) {
            if (c[i] == '1') {
                result = Math.max(i - pre - 1, result);
                pre = i;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        assertEquals(2, solution(9));
    }

    @Test
    public void test2() {
        assertEquals(4, solution(529));
    }

    @Test
    public void test3() {
        assertEquals(1, solution(20));
    }

    @Test
    public void test4() {
        assertEquals(0, solution(15));
    }

    @Test
    public void test5() {
        assertEquals(0, solution(32));
    }

    @Test
    public void test6() {
        assertEquals(5, solution(1041));
    }

    @Test
    public void test7() {
        assertEquals(0, solution(1));
    }

}
