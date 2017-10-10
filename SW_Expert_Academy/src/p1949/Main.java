package p1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Pair {
		int x;
		int y;
		int v;

		public Pair(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}

	static int dfs(int m, int n, int map[][], int N, int cnt) {
		boolean chk[][] = new boolean[N][N];
		Pair pair = new Pair(m, n, map[m][n]);
		chk[m][n] = true;
		int temp = 0;
		int result = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = pair.x + dx[i];
			int ny = pair.y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (map[nx][ny] < pair.v && chk[nx][ny] == false) {
					chk[nx][ny] = true;
					temp = dfs(nx, ny, map, N, cnt + 1);
					if (result < temp) {
						result = temp;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int result[] = new int[T];
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int map[][] = new int[N][N];
			int maxValue = 0;

			for (int m = 0; m < N; m++) {
				st = new StringTokenizer(br.readLine());
				for (int n = 0; n < N; n++) {
					map[m][n] = Integer.parseInt(st.nextToken());
					if (maxValue < map[m][n]) {
						maxValue = map[m][n];
					}
				}
			}

			int maxValueCount = 0;
			for (int s = 0; s < N; s++) {
				for (int d = 0; d < N; d++) {
					if (map[s][d] == maxValue) {
						maxValueCount++;
					}
				}
			}

			for (int m = 0; m < N; m++) {
				for (int n = 0; n < N; n++) {
					int temp[][] = new int[N][N];
					for (int k = 0; k < N; k++) {
						for (int j = 0; j < N; j++) {
							temp[k][j] = map[k][j];
						}
					}
					boolean flag = false;
					if (temp[m][n] == maxValue && maxValueCount == 1) {
						maxValue--;
						flag = true;
					}
					temp[m][n] -= K;
					for (int l = 0; l < N; l++) {
						for (int j = 0; j < N; j++) {
							if (temp[l][n] == maxValue) {
								int returnV = dfs(l, n, temp, N, 1);
								if (result[i] < returnV) {
									result[i] = returnV;
								}
							}
						}
					}
					if (flag == true) {
						maxValue++;
					}
				}
			}
		}
		int j = 1;
		for (int i : result) {
			System.out.println("#" + j + " " + i);
			j++;
		}
	}
}
