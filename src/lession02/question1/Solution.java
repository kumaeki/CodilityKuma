package lession02.question1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		Set<Integer> set = new HashSet<Integer>();
		for (int a : A) {
			if (set.contains(a)) {
				set.remove(a);
			} else {
				set.add(a);
			}
		}
		return set.iterator().next();
	}

	@Test
	public void test0() {
		int[] in = { 5, -1000 };
		int out = 1;
		assertEquals(out, solution(in));
	}

	@Test
	public void test1() {
		int[] in = { 3, 8, 9, 7, 6 };
		int out = 1;
		assertEquals(out, solution(in));
	}

	@Test
	public void test2() {
		int[] in = { 0, 0, 0 };
		int out = 1;
		assertEquals(out, solution(in));
	}

	@Test
	public void test3() {
		int[] in = { 1, 2, 3, 4 };
		int out = 1;
		assertEquals(out, solution(in));
	}
}
