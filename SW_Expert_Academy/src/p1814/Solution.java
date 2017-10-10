package p1814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int A, B;
	static int N;
	static int row[]; // За
	static int col[]; // ї­
	static int map[][];
	
	static boolean isPossible() {
		boolean result = true;
		
		return result;
	}
	static void back_tracking(int level) {
		int row_sum = 0;
		int col_sum = 0;
		for (int i=0; i<level; i++) {
			for (int j=0; j<N; j++) {
				row_sum += map[i][j];
			}
			if (row_sum < row[i]) {
				
			}
		}
		for (int i=0; i<level; i++) {
			for (int j=0; j<level; j++) {
				col_sum += map[j][i];
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			row = new int[N];
			col = new int[N];
			map = new int[N][N];
			for (int i=0; i<N;i++) {
				for (int j=0; j<N;j++) {
					map[i][j] = 0;
				}	
			}
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				row[n] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				col[n] = Integer.parseInt(st.nextToken());
			}
			
			
		}
	}
}
