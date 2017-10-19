package p2112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int D;
	static int W;
	static int K;
	static int Map[][];

	static boolean safeCheck(int copy_Map[][]) {
		boolean k_flag[] = new boolean[W];
		for (int w = 0; w < W; w++) {
			for (int d = 0; d <= D - K; d++) {
				boolean f = true;
				for (int k = 1; k < K; k++) {
					if (copy_Map[d][w] != copy_Map[d + k][w]) {
						f = false;
						d+=k-1;
						break;
					}
				}
				if (f == true) {
					k_flag[w] = true;
					break;
				}
			}
			if (k_flag[w] == false)
				return false;
		}
		return true;
	}

	static boolean repeatCheck(int Map[][], int cnt, int position) { // position=>
		boolean temp = false;
		int copy_Map1[][] = new int[D][W];
		for (int i = 0; i < 2; i++) {
			for (int d = position; d < D; d++) {
				for (int d1 = 0; d1 < D; d1++) {
					System.arraycopy(Map[d1], 0, copy_Map1[d1], 0, Map[d1].length);
				}
				for (int w = 0; w < W; w++) {
					copy_Map1[d][w] = i;
				}
				if (safeCheck(copy_Map1) == false) {
					if (cnt != 0) {
						temp = repeatCheck(copy_Map1, cnt - 1, d + 1);
						if (temp == true) {
							return true;
						}
					}
				} else {
					return true;
				}
			}
		}
		return temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			Map = new int[D][W];
			for (int d = 0; d < D; d++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					Map[d][w] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;

			boolean flag = safeCheck(Map); // 처음 돌려서 통과하면 while 않돈다.
			if (flag == false) {
				for (int i = 0; i < K - 1; i++) {
					flag = repeatCheck(Map, i, 0);
					if (flag == true) {
						ans = i + 1;
						break;
					}
				}
			}
			if (flag == false && ans == 0)
				ans = K;
			System.out.println("#" + (t + 1) + " " + ans);
		}
	}
}
