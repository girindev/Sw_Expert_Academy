package b13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static String Map[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int cnt = 10;

	static int dfs(int redX, int redY, int blueX, int blueY, int order, int cnt) {
		int result = 0;
		if (cnt == 10) {
			return cnt;
		}
		// �����¿� ������
		// ��
		if (order == 0) {
			if (redY == blueY) {
				if (redX < blueX) {
					// ���尡 ��纸�� ���� �ִ�
					int oriRedX = redX;
					while (Map[redX - 1][redY].equals(".")) {
						redX--;
					}
					Map[oriRedX][redY] = ".";
					Map[redX][redY] = "R";
					
					int oriBlueX = blueX;
					while (Map[blueX - 1][blueY].equals(".")) {
						blueX--;
					}
					Map[oriBlueX][blueY] = ".";
					Map[blueX][blueY] = "B";
				} else {
					// ��簡 ���庸�� ���� �ִ�.
					int oriBlueX = blueX;
					while (Map[blueX - 1][blueY].equals(".")) {
						blueX--;
					}
					Map[oriBlueX][blueY] = ".";
					Map[blueX][blueY] = "B";
					
					int oriRedX = redX;
					while (Map[redX - 1][redY].equals(".")) {
						redX--;
					}
					Map[oriRedX][redY] = ".";
					Map[redX][redY] = "R";
				}
			} else {
				int oriBlueX = blueX;
				while (Map[blueX - 1][blueY].equals(".")) {
					blueX--;
				}
				Map[oriBlueX][blueY] = ".";
				Map[blueX][blueY] = "B";
				
				int oriRedX = redX;
				while (Map[redX - 1][redY].equals(".")) {
					redX--;
				}
				Map[oriRedX][redY] = ".";
				Map[redX][redY] = "R";
			}
			if (Map[redX - 1][redY].equals("O") && blueX - 1 != redX) {
				// ���ÿ� ������ �ʴ� ���
				return cnt;
			} else if (Map[blueX + 1][blueY].equals("O")) {
				// ��簡 �������
				return 10;
			} else {
				// �ȵɰ�� �� 4�������� �̵�
				for (int i=0; i<N; i++) {
					
				}
				for (int i = 0; i < 4; i++) {
					int temp = dfs(redX, redY, blueX, blueY, i, cnt + 1);
					if (temp < result) {
						result = temp;
					}
				}
			}
		}
		// ��
		if (order == 1) {
			if (redY == blueY) {
				if (redX < blueX) {
					// ���尡 ��纸�� ���� �ִ�
					int oriRedX = redX;
					while (Map[redX + 1][redY].equals(".")) {
						redX++;
					}
					Map[oriRedX][redY] = ".";
					Map[redX][redY] = "R";
					
					int oriBlueX = blueX;
					while (Map[blueX + 1][blueY].equals(".")) {
						blueX++;
					}
					Map[oriBlueX][blueY] = ".";
					Map[blueX][blueY] = "B";
				} else {
					// ��簡 ���庸�� ���� �ִ�.
					int oriBlueX = blueX;
					while (Map[blueX + 1][blueY].equals(".")) {
						blueX++;
					}
					Map[oriBlueX][blueY] = ".";
					Map[blueX][blueY] = "B";
					
					int oriRedX = redX;
					while (Map[redX + 1][redY].equals(".")) {
						redX++;
					}
					Map[oriRedX][redY] = ".";
					Map[redX][redY] = "R";
				}
			} else {
				int oriBlueX = blueX;
				while (Map[blueX - 1][blueY].equals(".")) {
					blueX--;
				}
				Map[oriBlueX][blueY] = ".";
				Map[blueX][blueY] = "B";
				
				int oriRedX = redX;
				while (Map[redX - 1][redY].equals(".")) {
					redX--;
				}
				Map[oriRedX][redY] = ".";
				Map[redX][redY] = "R";
			}
			if (Map[redX + 1][redY].equals("O") && blueX + 1 != redX) {
				// ���ÿ� ������ �ʴ� ���
				return cnt;
			} else if (Map[blueX + 1][blueY].equals("O")) {
				// ��簡 �������
				return 10;
			} else {
				// �ȵɰ�� �� 4�������� �̵�
				for (int i = 0; i < 4; i++) {
					int temp = dfs(redX, redY, blueX, blueY, i, cnt + 1);
					if (temp < result) {
						result = temp;
					}
				}
			}
		}
		// ��
		if (order == 2) {
			if (redX == blueX) {
				if (redY < blueY) {
					// ���尡 ��纸�� �տ� �ִ�
					int oriRedY = redY;
					while (Map[redX][redY - 1].equals(".")) {
						redY--;
					}
					Map[redX][oriRedY] = ".";
					Map[redX][redY] = "R";
					
					int oriBlueY = blueY;
					while (Map[blueX][blueY - 1].equals(".")) {
						blueY--;
					}
					Map[blueX][oriBlueY] = ".";
					Map[blueX][blueY] = "B";

				} else {
					// ��簡 ���庸�� �տ� �ִ�.
					int oriBlueY = blueY;
					while (Map[blueX][blueY - 1].equals(".")) {
						blueY--;
					}
					Map[blueX][oriBlueY] = ".";
					Map[blueX][blueY] = "B";
					
					int oriRedY = redY;
					while (Map[redX][redY - 1].equals(".")) {
						redY--;
					}
					Map[redX][oriRedY] = ".";
					Map[redX][redY] = "R";
				}
			} else {
				while (Map[blueX][blueY - 1].equals(".")) {
					blueY--;
				}
				while (Map[redX][redY - 1].equals(".")) {
					redY--;
				}
			}
			if (Map[redX][redY - 1].equals("O") && blueY - 1 != redX) {
				// ���ÿ� ������ �ʴ� ���
				return cnt;
			} else if (Map[blueX][blueY - 1].equals("O")) {
				return 10;
			} else {
				// �ȵɰ�� �� 4�������� �̵�
				for (int i = 0; i < 4; i++) {
					int temp = dfs(redX, redY, blueX, blueY, i, cnt + 1);
					if (temp < result) {
						result = temp;
					}
				}
			}
		}
		// ��
		if (order == 3) {
			if (redX == blueX) {
				if (redY > blueY) {
					// ��簡 ���庸�� �տ� �ִ�
					int oriRedY = redY;
					while (Map[redX][redY + 1].equals(".")) {
						redY++;
					}
					Map[redX][oriRedY] = ".";
					Map[redX][redY] = "R";

					int oriBlueY = blueY;
					while (Map[blueX][blueY + 1].equals(".")) {
						blueY++;
					}
					Map[blueX][oriBlueY] = ".";
					Map[blueX][blueY] = "B";
				} else {
					// ��簡 ���庸�� �տ� �ִ�.
					int oriBlueY = blueY;
					while (Map[blueX][blueY + 1].equals(".")) {
						blueY++;
					}
					Map[blueX][oriBlueY] = ".";
					Map[blueX][blueY] = "B";

					int oriRedY = redY;
					while (Map[redX][redY + 1].equals(".")) {
						redY++;
					}
					Map[redX][oriRedY] = ".";
					Map[redX][redY] = "R";
				}
			} else {
				int oriRedY = redY;
				while (Map[redX][redY + 1].equals(".")) {
					redY++;
				}
				Map[redX][oriRedY] = ".";
				Map[redX][redY] = "R";

				int oriBlueY = blueY;
				while (Map[blueX][blueY + 1].equals(".")) {
					blueY++;
				}
				Map[blueX][oriBlueY] = ".";
				Map[blueX][blueY] = "B";
			}
			if (Map[redX][redY + 1].equals("O") && blueY + 1 != redX) {
				// ���ÿ� ������ �ʴ� ���
				return cnt;
			} else if (Map[blueX][blueY + 1].equals("O")) {
				return 10;
			} else {
				// �ȵɰ�� �� 4�������� �̵�
				for (int i = 0; i < 4; i++) {
					int temp = dfs(redX, redY, blueX, blueY, i, cnt + 1);
					if (temp < result) {
						result = temp;
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
		Map = new String[N][M];
		int redX = 0, redY = 0, blueX = 0, blueY = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String intputV = st.nextToken();
			for (int m = 0; m < M; m++) {
				Map[n][m] = "" + intputV.charAt(m);
				if (Map[n][m].equals("R")) {
					redX = n;
					redY = m;
				}
				if (Map[n][m].equals("B")) {
					blueX = n;
					blueY = m;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			int temp = dfs(redX, redY, blueX, blueY, i, 0);
			if (temp < ans) {
				ans = temp;
			}
		}
		System.out.println(ans);
	}
}
