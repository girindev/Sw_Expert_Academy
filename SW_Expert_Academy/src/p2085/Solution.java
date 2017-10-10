package p2085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int map[][];
	static boolean chk[][];
	static int N;
	static int count = 1;

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

	static int bfs(int x, int y, int K) {
		int result = map[x][y];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y, map[x][y]));
		chk = new boolean[N][N];
		chk[x][y] = true;
		for (int k = 1; k < K; k++) {
			int q_size = q.size();
			for (int r = 0; r < q_size; r++) {
				Pair p = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (0 <= nx && nx < N && 0 <= ny && ny < N && chk[nx][ny] == false) {
						chk[nx][ny] = true;
						q.add(new Pair(nx, ny, map[nx][ny]));
						result += map[nx][ny];
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
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int ans = 0;
			for (int n1 = 0; n1 < N; n1++) {
				st = new StringTokenizer(br.readLine());
				String value = st.nextToken();
				for (int n2 = 0; n2 < N; n2++) {
					map[n1][n2] = Integer.valueOf(value.charAt(n2) + "");
				}
			}
			if (N == 1) {
				ans = map[N-1][N-1];
			} else {
				ans = bfs(N / 2, N / 2, (N / 2) + 1);
			}
			System.out.println("#" +  count + " " + ans);
			count++;
		}
	}
}
