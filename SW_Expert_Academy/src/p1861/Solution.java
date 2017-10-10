package p1861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int map[][];
	static boolean chk[][];
	static int roomCount[][];
	static int cnt = 1;

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

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

	static int bfs(int x, int y) {
		int result = 1;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y, map[x][y]));
		chk = new boolean[N][N];
		chk[x][y] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (chk[nx][ny] == false && map[nx][ny] == (p.v + 1)) {
						q.add(new Pair(nx, ny, map[nx][ny]));
						chk[nx][ny] = true;
						result++;
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
			roomCount = new int[N][N];
			for (int n1 = 0; n1 < N; n1++) {
				st = new StringTokenizer(br.readLine());
				for (int n2 = 0; n2 < N; n2++) {
					map[n1][n2] = Integer.parseInt(st.nextToken());
				}
			}
			for (int n1 = 0; n1 < N; n1++) {
				for (int n2 = 0; n2 < N; n2++) {
					roomCount[n1][n2] = bfs(n1, n2);
				}
			}
			int ans = 0;
			int roomNum = N;
			for (int n1 = 0; n1 < N; n1++) {
				for (int n2 = 0; n2 < N; n2++) {
					if (ans == roomCount[n1][n2]) {
						if (roomNum > map[n1][n2])
							roomNum = map[n1][n2];
					} else if (ans < roomCount[n1][n2]) {
						roomNum = map[n1][n2];
						ans = roomCount[n1][n2];
					}
				}
			}
			System.out.println("#" + cnt + " " + roomNum + " " + ans);
			cnt++;
		}
	}
}
