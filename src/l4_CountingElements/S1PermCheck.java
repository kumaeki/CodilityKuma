package l4_CountingElements;

import java.util.HashSet;
import java.util.Set;

public class S1PermCheck {
	public int solution(int[] A) {

		int len = A.length;
		Set<Integer> set = new HashSet<>();
		for (int a : A) {
			set.add(new Integer(a));
			if (a > len) {
				return 0;
			}
		}
		if (set.size() < len) {
			return 0;
		}
		return 1;

	}
}
