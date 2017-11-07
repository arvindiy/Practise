package leet.problem_329;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

public class LongestIncreasingPath {

	public static void main(String args[]) {
		int[][] nums = { { 3, 4, 5, 7, 8 }, { 3, 2, 6, 1, 3 }, { 2, 2, 8, 2, 1 } };
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(nums));
	}

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[] max = new int[1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dfs(matrix, i, j, max, 1);
			}
		}

		return max[0];
	}

	public void dfs(int[][] matrix, int i, int j, int[] max, int len) {

		max[0] = Math.max(max[0], len);

		int m = matrix.length;
		int n = matrix[0].length;

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
				dfs(matrix, x, y, max, len + 1);
			}
		}
	}
}
