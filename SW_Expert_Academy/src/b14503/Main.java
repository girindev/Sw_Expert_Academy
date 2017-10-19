package b14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int Map[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static int dfs(int r, int c, int v, boolean chk[][]) {
		int result = 0;
		chk[r][c] = true;
		
		for (int i=0; i<4; i++) {
			int nx = r + dx[i];
			int ny = r + dy[i];
			
			if (0<=nx && nx<N && 0<=ny && ny<N) {
				if (Map[nx][ny] == 0 && chk[nx][ny] == false) {
					
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				Map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
