package p1949;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		Pair pair = new Pair(m, n, map[m][n]);
		int temp = 0;
		int result = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = pair.x + dx[i];
			int ny = pair.y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (map[nx][ny] < pair.v) {
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
			for (int m = 0; m < N; m++) {
				st = new StringTokenizer(br.readLine());
				for (int n = 0; n < N; n++) {
					map[m][n] = Integer.parseInt(st.nextToken());
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
					int smallK = K;
					while (true) {
						int maxValue = 0;
						int tempMN = temp[m][n];
						if (smallK == -1)
							break;
						temp[m][n] -= smallK;
						for (int s = 0; s < N; s++) {
							for (int d = 0; d < N; d++) {
								if (maxValue < temp[s][d]) {
									maxValue = temp[s][d];
								}
							}
						}
						for (int l = 0; l < N; l++) {
							for (int j = 0; j < N; j++) {
								if (temp[l][j] == maxValue) {
									int returnV = dfs(l, j, temp, N, 1);
									if (result[i] < returnV) {
										result[i] = returnV;
									}
								}
							}
						}
						temp[m][n] = tempMN;
						smallK--;
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
