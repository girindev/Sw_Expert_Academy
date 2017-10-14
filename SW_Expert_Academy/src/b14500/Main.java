package b14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int Map[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static boolean chk[][];
	static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x =x;
			this.y =y;
		}
	}
	
	static int dfs(int x, int y, int cnt, int sum){
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x,y));
		Pair p = q.poll();
		int result = 0;
		chk = new boolean[N][M];
		chk[x][y] = true;
		
		if (cnt == 0) {
			return sum;
		}
		
		for (int i=0; i<4; i++) {
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];
			if (0<=nx && nx<N && 0<=ny && ny <M && chk[nx][ny] == false){
				int temp = dfs(nx,ny,cnt-1, sum + Map[nx][ny]);
				if (result < temp) {
					result = temp;	
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
		int result = 0;
		for (int n=0; n<N; n++){
			st = new StringTokenizer(br.readLine());
			for (int m=0; m<M; m++) {
				Map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		for (int n=0; n<N; n++){
			for (int m=0; m<M; m++) {	
				int temp = dfs(n,m,3,Map[n][m]);
				if (temp > result) {
					result = temp;
				}
			}
		}
		System.out.println(result);
	}
}
