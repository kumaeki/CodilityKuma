package l1_Iterations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class S1BinaryGap {

	public int solution(int N) {
		char[] c = Integer.toBinaryString(N).toCharArray();
		int result_gap = 0;
		int gap_recent = 0;
		int left = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '1') {
				if (i != 0) {
					gap_recent = i - left - 1;
					if (gap_recent > result_gap) {
						result_gap = gap_recent;
					}
				}
				left = i;

			}
		}
		return result_gap;
	}

	public void test1() {
		assertEquals(5, solution(1041));
	}

	public void test2() {
		assertEquals(0, solution(32));
	}

	@Test
	public void test3() {
		assertEquals(2, solution(328));
	}

}
