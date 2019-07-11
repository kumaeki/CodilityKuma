package l3_TimeComplexity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class S2PermMissingElem {
	public int solution(int X, int Y, int D) {

		int dis = Y - X;
		int result = dis / D;
		if (dis % D > 0) {
			result = result + 1;
		}
		return result;
	}

	@Test
	public void test0() {
		int x = 10;
		int y = 85;
		int d = 30;
		int out = 3;
		assertEquals(out, solution(x, y, d));
	}

}
