package lesson90_2015Challenge.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LongestPassword {

    public int solution(String S) {
        char[] arr = S.toCharArray();
        int n = arr.length;
        int max = -1;
        int start = 0;
        int letterCount = 0;
        int digitCount = 0;
        // if the word valid
        boolean flg = true;
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (Character.isWhitespace(c)) {
                if (flg && letterCount % 2 == 0 && digitCount % 2 != 0) {
                    max = Math.max(max, i - start);
                }
                letterCount = 0;
                digitCount = 0;
                start = i + 1;
                flg = true;
            } else {
                if (flg) {
                    if (Character.isAlphabetic(c)) {
                        letterCount++;
                    } else if (Character.isDigit(c)) {
                        digitCount++;
                    } else {
                        flg = false;
                    }
                }
            }
        }
        if (flg && letterCount % 2 == 0 && digitCount % 2 != 0) {
            max = Math.max(max, n  - start);
        }
        return max;
    }

    @Test
    public void testExample() {
        String S = "test 5 a0A pass007 ?xy1";
        int result = 7;
        assertEquals(result, new LongestPassword().solution(S));
    }

    @Test
    public void testSimple1() {
        String S = "?xy1";
        int result = -1;
        assertEquals(result, new LongestPassword().solution(S));
    }

    @Test
    public void testSimple2() {
        String S = "    ";
        int result = -1;
        assertEquals(result, new LongestPassword().solution(S));
    }

    @Test
    public void testSimple3() {
        String S = " test 5 a0A pass007 ?xy1  ";
        int result = 7;
        assertEquals(result, new LongestPassword().solution(S));
    }
    
    @Test
    public void testSimple4() {
        String S = " test 5 a0A pass0007 ?xy1  a0A ";
        int result = 3;
        assertEquals(result, new LongestPassword().solution(S));
    }
    
    @Test
    public void testSimple5() {
        String S = "0";
        int result = 1;
        assertEquals(result, new LongestPassword().solution(S));
    }
}
