package b3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static final int APPLE = 1;
	static int head = 0;
	static int cnt = 0;
	static int nowDirection = 3;
	static int dx[] = { -1, 1, 0, 0 }; // 0상 1하 2좌 3우
	static int dy[] = { 0, 0, -1, 1 };
	static int moveX[];
	static String moveC[];
	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		ArrayList<Pair> dummy = new ArrayList<>();

		dummy.add(new Pair(0, 0));

		// 사과 세팅
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1] = APPLE;
		}
		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		moveX = new int[size];
		moveC = new String[size];
		
		for (int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			moveX[i] = x;
			moveC[i] = c;
		}
		int start = 0;
		boolean flag = true;
		while (flag) {
			if (start != size && cnt == moveX[start]) {
				if (moveC[start].equals("L")) {
					if (nowDirection == 0)
						nowDirection = 2;
					else if (nowDirection == 1)
						nowDirection = 3;
					else if (nowDirection == 2)
						nowDirection = 1;
					else if (nowDirection == 3)
						nowDirection = 0;
				} else {
					if (nowDirection == 0)
						nowDirection = 3;
					else if (nowDirection == 1)
						nowDirection = 2;
					else if (nowDirection == 2)
						nowDirection = 0;
					else if (nowDirection == 3)
						nowDirection = 1;
				}
				start++;
			}
			int nx = dummy.get(head).x + dx[nowDirection];
			int ny = dummy.get(head).y + dy[nowDirection];
			//스스로 부딪칠경우
			for (int i = 0; i <= head; i++) {
				if (nx == dummy.get(i).x && ny == dummy.get(i).y) {
					flag = false;
					break;
				}
			}
			cnt++;
			if (0 <= nx && nx < N && 0 <= ny && ny < N && flag) {
				dummy.add(new Pair(nx, ny));
				if (map[nx][ny] == APPLE) {
					map[nx][ny] = 0;
					head++;
				} else {
					dummy.remove(0);
				}
			} else {
				// 뱀이 밖으로 나갈경우
				flag = false;
			}
		}
		System.out.println(cnt);
	}
}
