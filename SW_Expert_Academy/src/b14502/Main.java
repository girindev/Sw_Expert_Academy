package b14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int Map[][];
	static int dx[] = {0,-1,0,1};
	static int dy[] = {-1,0,1,0};
	static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int bfs(int tempMap[][]) {
		Queue<Pair> q = new LinkedList<>();
		boolean chk[][] = new boolean[N][M];
		int result = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (tempMap[i][j] == 2){
					q.add(new Pair(i, j));
					chk[i][j] = true;
					result++;
				}
			}
		}
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for (int i=0; i<4; i++){
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (0<= nx && nx < N && 0<=ny && ny<M){
					if (chk[nx][ny] == false && tempMap[nx][ny] == 0) {
						q.add(new Pair(nx,ny));
						tempMap[nx][ny] = 2;
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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new int[N][M];
		
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m=0; m<M; m++) {
				Map[n][m] = Integer.parseInt(st.nextToken());
			}	
		}
		int min_birus = N*M;
		for (int n=0; n<N; n++) {
			for (int m=0; m<M; m++) {
				if (Map[n][m] == 0) {
					for (int n1=n; n1<N; n1++){
						for (int m1=0; m1<M; m1++) {
							if (Map[n1][m1] == 0 && (n!=n1 || m!=m1)) {
								for (int n2=n1; n2<N; n2++){
									for (int m2=0; m2<M; m2++) {
										if (Map[n2][m2] == 0 && (n!=n2 || m!=m2) && (n1!=n2 || m1!=m2)) {
											int tempMap[][] = new int[N][M];
											for (int i=0; i<N; i++) {
												System.arraycopy(Map[i], 0, tempMap[i], 0, Map[i].length);
											}
											tempMap[n][m] = 1;
											tempMap[n1][m1] = 1;
											tempMap[n2][m2] = 1;
											int temp = bfs(tempMap);
											if (min_birus > temp) {
												min_birus = temp;
											}
										}
									}
								}
							}
						}
					}
				}
			}	
		}
		int wall = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (Map[i][j] == 1) {
					wall++;
				}
			}	
		}
		System.out.println(N*M - min_birus - wall -3);
	}
}
