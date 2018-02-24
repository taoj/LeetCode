package Issues;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤
 * n ≤ 9, count the total number of unlock patterns of the Android lock screen,
 * which consist of minimum of m keys and maximum n keys.
 * 
 * Rules for a valid pattern: Each pattern must connect at least m keys and at
 * most n keys. All the keys must be distinct. If the line connecting two
 * consecutive keys in the pattern passes through any other keys, the other keys
 * must have previously selected in the pattern. No jumps through non selected
 * key is allowed. The order of keys used matters.
 * 
 * Explanation: | 1 | 2 | 3 | | 4 | 5 | 6 | | 7 | 8 | 9 | Invalid move: 4 - 1 -
 * 3 - 6 Line 1 - 3 passes through key 2 which had not been selected in the
 * pattern.
 * 
 * Invalid move: 4 - 1 - 9 - 2 Line 1 - 9 passes through key 5 which had not
 * been selected in the pattern.
 * 
 * Valid move: 2 - 4 - 1 - 3 - 6 Line 1 - 3 is valid because it passes through
 * key 2, which had been selected in the pattern
 * 
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2 Line 1 - 9 is valid because it passes
 * through key 5, which had been selected in the pattern.
 * 
 * Example: Given m = 1, n = 1, return 9.
 * 
 */

public class Q351 {
	public int numberOfPatterns(int m, int n) {

		boolean[] visited = new boolean[10];
		for (int i = 0; i < 10; i++) {
			visited[i] = false;
		}

		int[][] mapping = new int[10][10];

		mapping[1][3] = 2;
		mapping[1][7] = 4;
		mapping[1][9] = 5;
		mapping[2][8] = 5;
		mapping[3][1] = 2;
		mapping[3][7] = 5;
		mapping[3][9] = 6;
		mapping[4][6] = 5;
		mapping[6][4] = 5;
		mapping[7][1] = 4;
		mapping[7][3] = 5;
		mapping[7][9] = 8;
		mapping[8][2] = 5;
		mapping[9][1] = 5;
		mapping[9][3] = 6;
		mapping[9][7] = 8;

		// 1
		visited[1] = true;

		int count1 = process(1, m, n, visited, mapping, 1);
		// 2
		visited[1] = false;
		visited[2] = true;

		int count2 = process(1, m, n, visited, mapping, 2);

		// 5
		visited[2] = false;
		visited[5] = true;

		int count5 = process(1, m, n, visited, mapping, 5);

		return count1 * 4 + count2 * 4 + count5;

	}

	int process(int level, int m, int n, boolean[] visited, int[][] mapping, int current) {
		if (level == n) {
			return 1;
		}

		int count = 0;

		for (int i = 1; i <= 9; i++) {
			if (!visited[i]) {
				if (mapping[current][i] == 0 || visited[mapping[current][i]]) {
					visited[i] = true;
					count += process(level + 1, m, n, visited, mapping, i);
					visited[i] = false;
				}
			}
		}

		if (level >= m) {
			count += 1;
		}

		return count;

	}
}
