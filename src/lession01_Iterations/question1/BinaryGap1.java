package lession01_Iterations.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinaryGap1 {

    public int solution(int N) {
        char[] c = Integer.toBinaryString(N).toCharArray();
        int len = c.length;
        int result = 0;
        // the start position of BinaryGap
        for (int start = 0; start < len - 1; start++) {
            if (c[start] == '1') {
                continue;
            }
            // the end position of BinaryGap
            int end = start + 1;
            while (end < len) {
                if (c[end] == '1') {
                    break;
                }
                end++;
            }
            if (end < len && c[end] != '0') {
                result = Math.max(result, end - start);
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
