package lession03.question3;

import junit.framework.TestCase;

public class Solution extends TestCase {
	public int solution(int[] A) {

		int sumLeft = 0;
		int sumRight = 0;
		int diff = 0;
		int result = 0;

		sumLeft = A[0];
		for (int i = 1; i < A.length; i++) {
			sumRight += A[i];
		}
		diff = Math.abs(sumLeft - sumRight);
		result = diff;

		for (int i = 1; i < A.length - 1; i++) {
			sumLeft += A[i];
			sumRight -= A[i];
			diff = Math.abs(sumLeft - sumRight);
			if(diff<result) {
				result = diff;
			}

		}

		return result;
	}

	public void test0() {
		int[] in = { 3, 1, 2, 4, 3 };
		int out = 1;
		assertEquals(out, solution(in));
	}

}
