package p2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // �׽�Ʈ ���̽�

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// ���� ũ��
			int M = Integer.parseInt(st.nextToken());// ä�� ���� ����
			int C = Integer.parseInt(st.nextToken());// �ִ� ��
			map = new int[N][N];
			for (int n1 = 0; n1 < N; n1++) {
				st = new StringTokenizer(br.readLine());
				for (int n2 = 0; n2 < N; n2++) {
					map[n1][n2] = Integer.parseInt(st.nextToken());
				}
			}
			int results[] = new int[2];
			int mValues[] = new int[M];
			for (int i = 0; i < 2; i++) {
				for (int n1 = 0; n1 < N; n1++) {
					for (int n2 = 0; n2 < N - M + 1; n2++) {
						int sum = 0;
						for (int m = 0; m < M; m++) {
							mValues[m] = map[n1][n2+m];
							sum += mValues[m];
						}
						//ä�� ����
						if (sum <= C) {
							int temp = 0;
							for (int m=0; m<M; m++) {
								temp += Math.multiplyExact(mValues[m], mValues[m]); 
							}
							if (results[i] < temp) {
								results[i] = temp;
							}
						}
						//ä�� �Ұ���
						if(sum > C) {
							int temp[] = new int[M];
							int tempSum = 0;
							int tempResult = 0;
							for (int m=0; m<M; m++) {
								if (temp[i] < mValues[m]){
									temp[i] = mValues[m];
									tempSum = mValues[m];
								}
								for (int a=m+1; a<M; a++) {
									if (tempSum + mValues[a] < C) {
										i++;
										temp[i] = mValues[a];
										tempSum += mValues[a];
									}
								}
							}
							for (int v : temp) {
								tempResult += (v * v);
							}
							if (results[i] < tempResult) {
								results[i] = tempResult;
							}
						}
					}
				}
			}
		}
	}
}
