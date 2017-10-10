package p2105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int T; //테스트 케이스
	static int N[]; 
	static int []dx = {1, 0, -1};
	static int []dy = {1, 2, 1};
	static Set<Integer> chk;
	static ArrayList<ArrayList<Integer>> dList;
	static class Pair{
		int x;
		int y;
		int v;
		public Pair(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}
	static void bfs(int x, int y, int v, int range, int map[][]) { // range = N[i]
		chk = new LinkedHashSet<>();
//		Queue<Pair> q = new LinkedList<>();
//		q.add(new Pair(x,y,v));
		chk.add(v);
//		while(!q.isEmpty()) {
			boolean flag = true;
//			Pair pair = q.poll();
			dList.add(new ArrayList<>());
			for (int i=0; i<3; i++) {
//				int nowX = pair.x + dx[i];
//				int nowY = pair.y + dy[i];
				int nowX = x + dx[i];
				int nowY = y + dy[i];
				if ((0 <= nowX && nowX < range) 
						&& (0 <= nowY && nowY < range) 
							&& chk.add(map[nowY][nowX])){
				} else {
					flag = false;
				}
			}
			if (flag == true) {
				for (int v1 : chk) {
					dList.get(dList.size()-1).add(v1);
				}
			} 
//		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		N = new int[T];
		dList = new ArrayList<>();
 		for (int i=0; i<T; i++){
			st = new StringTokenizer(br.readLine());
			N[i] = Integer.parseInt(st.nextToken());
			int map[][] = new int[N[i]][N[i]];
			//맵 초기화 
			for (int j=0; j<N[i]; j++){
				st = new StringTokenizer(br.readLine());
				int m =0;
				while(st.hasMoreTokens()) {
					map[j][m++] = Integer.parseInt(st.nextToken());
				}
			}
			//bfs
			for (int u=0; u<N[i]; u++) {
				for (int v=0; v <N[i]; v++) {
					bfs(v,u,map[u][v],N[i],map);
				}
			}
		}
		for (int i=0; i<dList.size(); i++) {
			for (int j : dList.get(i)) {
				System.out.print(j +" ");
			}
			System.out.println("");
		}
	}
}
