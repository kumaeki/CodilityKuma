package lession03.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
	public int solution(int[] A) {
		int len = A.length;
		int[] resultArr = new int[len + 2];
		for (int a : A) {
			resultArr[a] = a;
		}
		for (int i = 1; i < resultArr.length+1; i++) {
			if (resultArr[i] == 0) {
				return i;
			}
		}
		return 1;

//		int len = A.length;
//
//		if (len == 0) {
//			return 1;
//		} else if (len == 1) {
//			return A[0] % 2 + 1;
//		}
//		int temp;
//		int result = 0;
//		for (int j = 1; j < len; j++) {
//			for (int i = 0; i < len - j; i++) {
//				if (A[i] < A[i + 1]) {
//					temp = A[i];
//					A[i] = A[i + 1];
//					A[i + 1] = temp;
//				}
//
//			}
//			if (A[len - j] + 1 != A[len - j - 1]) {
//				result = A[len - j] + 1;
//			}
//		}
//		return result;
	}

	@Test
	public void test0() {
		int[] in = { 1, 2, 3, 4, 6 };
		int out = 5;
		assertEquals(out, solution(in));
	}

	@Test
	public void test1() {
		int[] in = { 2, 3, 1, 5 };
		int out = 4;
		assertEquals(out, solution(in));
	}

	@Test
	public void test2() {
		int[] in = { 6, 5, 3, 2, 1 };
		int out = 4;
		assertEquals(out, solution(in));
	}

	@Test
	public void test3() {
		int[] in = {};
		int out = 1;
		assertEquals(out, solution(in));
	}

	@Test
	public void test4() {
		int[] in = { 1 };
		int out = 2;
		assertEquals(out, solution(in));
	}

	@Test
	public void test5() {
		int[] in = { 2 };
		int out = 1;
		assertEquals(out, solution(in));
	}
}
