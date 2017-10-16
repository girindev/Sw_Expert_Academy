package p2383;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int Map[][];
	static Stair stair[];
	static ArrayList<Stair> person;
	static int[][] route;
	static int cnt=0;
	static int total_person_num;
	static class Stair{
		int x;
		int y;
		int v;
		
		public Stair(int x, int y, int v) {
			this.x =x;
			this.y =y;
			this.v = v;
		}
	}
	
	static int distance(int pr, int pc, int sr, int sc){
		int result = Math.abs(pr-sr) + Math.abs(pc-sc);
		return result;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Map = new int[N][N];
			stair = new Stair[2];
			person = new ArrayList<>();
			route = new int[1024][10];
			for (int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int i=0; i<N; i++) {
					Map[n][i] = Integer.parseInt(st.nextToken());
					if (Map[n][i] > 1) {
						if (stair[0] == null){
							stair[0] = new Stair(n, i, Map[n][i]);
						} else {
							stair[1] = new Stair(n, i,Map[n][i]);
						}
					} else if (Map[n][i] == 1) {
						person.add(new Stair(n,i,Map[n][i]));
					}
				}
			}
			for (int i=1; i<3; i++) {
				total_person_num = person.size();
				dfs(0, i, 0);
			}
			for (int i=0; i<1024; i++) {
				for (int j : route[i]) {
					System.out.print(j +" ");
				}
				System.out.println();
			}
		}
	}
	static void dfs(int now_person_num, int stair_num, int cnt) {
		if (now_person_num == total_person_num) {
			return; 
		} 
		//1번계단
		if (stair_num == 1) {
			//1번 사람 -> 1번 계단
			route[cnt][now_person_num] = stair_num;
			for (int i=1; i <3; i++) {
				dfs(now_person_num +1, i, cnt+1);
			}
		} 			
		//2번계단
		else {
			route[cnt][now_person_num] = stair_num;
			for (int i=1; i <3; i++) {
				dfs(now_person_num +1, i, cnt+1);
			}
		}
	}
}
