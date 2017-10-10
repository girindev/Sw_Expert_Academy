package p2117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int map[][] = null;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int count = 1;
	static boolean[][] chk;
	
	static int kSize(int k) {
		return (k * k) + ((k - 1) * (k - 1));
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int bfs(int x, int y, int k) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		chk = new boolean[N][N];
		chk[x][y] = true;
		int cnt = 0;
		
		if (map[x][y] == 1) {
			cnt++;
		}
		
		for (int i = 0; i < k; i++) { // k 만큼
			int temp = q.size(); 
			for (int qSize = 0; qSize < temp; qSize++) {
				Pair p = q.poll();
				for (int j = 0; j < 4; j++) { // 4방향
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (0 <= nx && nx < N && 0 <= ny && ny < N && chk[nx][ny] == false) {
						chk[nx][ny] = true;
						q.add(new Pair(nx, ny));
						if (map[nx][ny] == 1) {
							cnt++;
						}
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 도시 크기
			int M = Integer.parseInt(st.nextToken()); // 지불액
			map = new int[N][N];
			int homeCount = 0;
			for (int n1 = 0; n1 < N; n1++) {
				st = new StringTokenizer(br.readLine());
				for (int n2 = 0; n2 < N; n2++) {
					map[n1][n2] = Integer.parseInt(st.nextToken());
					if (map[n1][n2] == 1) {
						homeCount++;
					}
				}
			}
			int maxHomeCount[] = new int[homeCount * M];
			for (int i=0; i<maxHomeCount.length; i++) {
				maxHomeCount[i] = 1;
			}
			for (int k = 1; kSize(k) <= homeCount * M; k++) {
				int temp = 0;
				for (int n1 = 0; n1 < N; n1++) {
					for (int n2 = 0; n2 < N; n2++) {
						temp = bfs(n1, n2, k);
						if (kSize(k+1) <= temp * M) {
							if (maxHomeCount[k] < temp) {
								maxHomeCount[k] = temp;
							}
						}
					}
				}
			}
			int ans = 0;
			for (int v : maxHomeCount) {
				if (ans < v)
					ans = v;
			}
			System.out.println("#"+count + " " + ans);
			count++;
		}
	}
}
