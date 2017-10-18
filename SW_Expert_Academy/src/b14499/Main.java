package b14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//주사위 - 완료
public class Main {
	static int N;
	static int M;
	static int X;
	static int Y;
	static int K;
	static int Map[][];
	static int Move[];
	static ArrayList<Integer> result;
	static int Dice[];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Dice = new int[6];
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Map = new int[N][M];
		Move = new int[K];
		result = new ArrayList<>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				Map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			Move[k] = Integer.parseInt(st.nextToken());
		}
		Dice[3] = Map[X][Y]; // dice 시작 값
		// 4일때
		for (int k = 0; k < K; k++) {
			int nx = X + dx[Move[k] - 1];
			int ny = Y + dy[Move[k] - 1];
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (Move[k] == 1) {
					int temp[] = new int[6];
					temp[0] = Dice[0];
					temp[1] = Dice[4];
					temp[2] = Dice[2];
					temp[3] = Dice[5];
					temp[4] = Dice[3];
					temp[5] = Dice[1];
					System.arraycopy(temp, 0, Dice, 0, temp.length);
					
				} else if (Move[k] == 2) {
					int temp[] = new int[6];
					temp[0] = Dice[0];
					temp[4] = Dice[1];
					temp[2] = Dice[2];
					temp[5] = Dice[3];
					temp[3] = Dice[4];
					temp[1] = Dice[5];
					System.arraycopy(temp, 0, Dice, 0, temp.length);
					
				} else if (Move[k] == 3) {
					int temp[] = new int[6];
					temp[0] = Dice[1];
					temp[1] = Dice[2];
					temp[2] = Dice[3];
					temp[3] = Dice[0];
					temp[4] = Dice[4];
					temp[5] = Dice[5];
					System.arraycopy(temp, 0, Dice, 0, temp.length);
					
				} else if (Move[k] == 4) {
					int temp[] = new int[6];
					temp[0] = Dice[3];
					temp[1] = Dice[0];
					temp[2] = Dice[1];
					temp[3] = Dice[2];
					temp[4] = Dice[4];
					temp[5] = Dice[5];
					System.arraycopy(temp, 0, Dice, 0, temp.length);
				}
				if (Map[nx][ny] == 0) {
					Map[nx][ny] = Dice[3]; // 바닥은 무조건 3
				} else {
					Dice[3] = Map[nx][ny];
					Map[nx][ny] = 0;
				}
				result.add(Dice[1]);
				X = nx;
				Y = ny;
			}
		}
		for (int i : result) {
			System.out.println(i);
		}
	}
}
