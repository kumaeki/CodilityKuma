package l6_Sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;


public class S2Distinct {
    public int solution(int[] A) {
        int len = A.length;
        Set<Integer> s = new HashSet<Integer>(len, 1);
        for (int i : A) {
            s.add(i);
        }
        return s.size();
    }

    @Test
    public void testExample() {
        int[] A = { 1, 2, 3, 1, 2, 3 };
        assertEquals(3, new S2Distinct().solution(A));
    }
}
