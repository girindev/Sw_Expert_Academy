package p2105;

import java.util.Scanner;

public class Main {
	static int N;
	static int Map[][];
	// -1, 1 --> 못가면 끝임 못가는거임
	static int dx[] = { 1, 1, -1, -1 };
	static int dy[] = { 1, -1, -1, 1 };
	static int firstX, firstY;

	static int searchCafe(int cnt, int x, int y, int direction, int chkArray[], boolean first) {
		int result = 0;
		chkArray[Map[x][y]] = Map[x][y];
		int nx = x + dx[direction];
		int ny = y + dy[direction];

		boolean flag1 = true;
		boolean flag2 = true;
		while (true) {
			if (flag1) {
				// 왔던 방향으로 갈 수 있는 경우
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (nx == firstX && ny == firstY) {
						result = cnt;
					} else if (chkArray[Map[nx][ny]] == 0) {
						int copyArray[] = new int[101];
						for (int i = 0; i < 101; i++)
							copyArray[i] = chkArray[i];
						result = Math.max(result,searchCafe(cnt + 1, nx, ny, direction, copyArray, false));
					}
				}
				flag1 = false;
				// 가지 못하는 경우
			} else if (flag2) {
				nx = x + dx[direction];
				ny = y + dy[direction];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (nx == firstX && ny == firstY) {
						result = cnt;
					} else if (chkArray[Map[nx][ny]] == 0) {
						int copyArray[] = new int[101];
						for (int i = 0; i < 101; i++)
							copyArray[i] = chkArray[i];
						result = Math.max(result,searchCafe(cnt + 1, nx, ny, direction, copyArray, false));
					}
				}
				flag2 = false;
			}
			if (first == true) {
				break;
			}
			if (flag1 == false && flag2 == false)
				break;
			direction++; // 방향을 바꿔준다.
			if (direction == 4)
				return result;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			N = in.nextInt();
			Map = new int[N][N];
			for (int n = 0; n < N; n++) {
				for (int n_ = 0; n_ < N; n_++) {
					Map[n][n_] = in.nextInt();
				}
			}
			int local_result = 1;
			for (int n = 0; n < N - 2; n++) {
				for (int n_ = 1; n_ < N - 1; n_++) {
					firstX = n;
					firstY = n_;
					int chkArray[] = new int[101];
					local_result = Math.max(searchCafe(1, n, n_, 0, chkArray, true), local_result);
				}
			}
			if (local_result == 1)
				local_result = -1;
			System.out.println("#" + (t+1) +" " + local_result);
		}
	}
}