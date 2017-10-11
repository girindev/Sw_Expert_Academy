package p2382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, K;
	static int map[][];
	static ArrayList<Micro> micro;
	static Queue<Micro> q;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static class Micro {
		int x;
		int y;
		int cnt;
		int des;

		public Micro(int x, int y, int cnt, int des) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.des = des; // 1 상, 2하, 3좌, 4우
		}
	}

	static int bfs() {
		int result = 0;
		// Quque<>
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) { // 테스트 케이스
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K =  Integer.parseInt(st.nextToken());
			map = new int[N][N];
			micro = new ArrayList<>();
			q = new LinkedList<>();
			// int result = 0;
			for (int n1 = 0; n1 < N; n1++) {
				map[0][n1] = -1;
				map[n1][0] = -1;
				map[N - 1][n1] = -1;
				map[n1][N - 1] = -1;
			}
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				micro.add(new Micro(x, y, cnt, dir));
			}
			for (int m = 0; m < M; m++) {
				for (int i = 0; i < micro.size(); i++) {
					Micro mc = micro.get(i);
					mc.x += dx[mc.des - 1];
					mc.y += dy[mc.des - 1];
					if (mc.x != 0 && mc.x != N - 1 && mc.y != 0 && mc.y != N - 1) {
						map[mc.x][mc.y] = 1;
					} else {
						if (mc.x == 0 || mc.x == N - 1) {
							mc.cnt /= 2;
							mc.des = 5 - mc.des;
						} else if (mc.y == 0 || mc.y == N - 1) {
							mc.cnt /= 2;
							mc.des = 3 - mc.des;
						}
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] == 1) {
							int index = 0;
							int sum = 0;
							int temp1 = 0;
							for (int x = 0; x < micro.size(); x++) {
								if (micro.get(x).x == i && micro.get(x).y == j) {
									sum += micro.get(x).cnt;
									if (temp1 < micro.get(x).cnt) {
										temp1 = micro.get(x).cnt;
										index = x;
									} else {
										micro.remove(micro.get(x));
									}
								}
							}
							micro.get(index).cnt = sum;
						}
					}
				}
			}
			int ans =0;
			for (int i=0; i<micro.size(); i++){
				ans += micro.get(i).cnt;
			}
			System.out.println(ans);
		}
	}
}
