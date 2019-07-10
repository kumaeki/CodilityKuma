package L5_PrefixSums;

/**
 * 
 * Find the minimal nucleotide from a range of sequence DNA.
 * 
 * @author xiong_yi
 *
 */
public class S3GenomicRangeQuery {

	public int[] solution(String S, int[] P, int[] Q) {
		int reLen = P.length;
		int[] result = new int[reLen];

		S = S.trim();
		int sLen = S.length();
		int[] sumArr = { 0, 0, 0, 0 };
		int[][] sumArrList = new int[sLen][4];
		for (int i = 0; i < sLen; i++) {
			char s = S.charAt(i);
			switch (s) {
			case 'A':
				sumArr[0] += 1;
				break;
			case 'C':
				sumArr[1] += 1;
				break;
			case 'G':
				sumArr[2] += 1;
				break;
			case 'T':
				sumArr[3] += 1;
				break;
			default:
				break;
			}
			int[] sumArrTemp = sumArr.clone();
			sumArrList[i] = sumArrTemp;
		}

		for (int i = 0; i < reLen; i++) {
			int p = P[i];
			int q = Q[i];
			int[] subtract = new int[4];
			if (p == 0) {
				subtract = sumArrList[q];
			} else {
				subtract = arrSubtract(sumArrList[q], sumArrList[p - 1]);
			}

			if (subtract[0] != 0) {
				result[i] = 1;
			} else if (subtract[1] != 0) {
				result[i] = 2;
			} else if (subtract[2] != 0) {
				result[i] = 3;
			} else {
				result[i] = 4;
			}
		}

		return result;
	}

	private int[] arrSubtract(int[] from, int[] to) {
		int len = from.length;
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			result[i] = from[i] - to[i];
		}
		return result;
	}

	public static void main(String[] args) {
		String S = "CAGCCTA ";
		int[] P = { 2, 5, 0 };
		int[] Q = { 4, 5, 6 };
		int[] result = new S3GenomicRangeQuery().solution(S, P, Q);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
