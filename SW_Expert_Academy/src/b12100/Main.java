package b12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2048(Easy)
//https://www.acmicpc.net/problem/12100
public class Main {
	static int N;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int n1 = 0; n1 < N; n1++) {
				map[n][n1] = Integer.parseInt(st.nextToken());
			}
		}
		int temp[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = map[i][j];
			}
		}			
		int copyArray[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(temp[i], 0, copyArray[i], 0, temp[i].length);
		}

		for (int i = 0; i < 4; i++) {
			repeat(copyArray, i, 5);
		}
		System.out.println(result);
	}

	static void repeat(int temp[][], int direction, int cnt) {
		if (cnt == 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (result < temp[i][j])
						result = temp[i][j];
				}
			}
			return;
		}

		// 상
		if (direction == 0) {
			int copyArray[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				System.arraycopy(temp[i], 0, copyArray[i], 0, temp[i].length);
			}
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					if (copyArray[i][j] == copyArray[i + 1][j]) {
						copyArray[i][j] *= 2;
						for (int k = i + 1; k < N - 1; k++) {
							copyArray[k][j] = copyArray[k + 1][j];
						}
						copyArray[N - 1][j] = 0;
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				// TODO Array 카피해서 넘기기
				repeat(copyArray, i, cnt - 1);
			}
		}
		// 하
		if (direction == 1) {
			int copyArray[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				System.arraycopy(temp[i], 0, copyArray[i], 0, temp[i].length);
			}
			for (int i = N - 1; i > 0; i--) {
				for (int j = 0; j < N; j++) {
					if (copyArray[i][j] == copyArray[i - 1][j]) {
						copyArray[i][j] *= 2;
						for (int k = i - 1; k > 0; k--) {
							copyArray[k][j] = copyArray[k - 1][j];
						}
						copyArray[0][j] = 0;
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				repeat(copyArray, i, cnt - 1);
			}
		}
		// 좌
		if (direction == 2) {
			int copyArray[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				System.arraycopy(temp[i], 0, copyArray[i], 0, temp[i].length);
			}
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					if (copyArray[j][i] == copyArray[j][i + 1]) {
						copyArray[j][i] *= 2;
						for (int k = i + 1; k < N - 1; k++) {
							copyArray[j][k] = copyArray[j][k + 1];
						}
						copyArray[j][N - 1] = 0;
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				repeat(copyArray, i, cnt - 1);
			}
		}
		// 우
		if (direction == 3) {
			int copyArray[][] = new int[N][N];
			for (int i = 0; i < N; i++) {    
				System.arraycopy(temp[i], 0, copyArray[i], 0, temp[i].length);
			}
			for (int i = 0; i < N-1; i++) {
				for (int j = N-1; j > 0; j--) {
					if (copyArray[i][j] == copyArray[i][j - 1]) {
						copyArray[i][j] *= 2;
						for (int k = j - 1; k > 0; k--) {
							copyArray[i][k] = copyArray[i][k - 1];
						}
						copyArray[i][0] = 0;
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				repeat(copyArray, i, cnt - 1);
			}
		}
	}
}