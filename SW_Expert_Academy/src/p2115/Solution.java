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
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 벌통 크기
			int M = Integer.parseInt(st.nextToken());// 채집 벌통 개수
			int C = Integer.parseInt(st.nextToken());// 최대 양
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
						//채집 가능
						if (sum <= C) {
							int temp = 0;
							for (int m=0; m<M; m++) {
								temp += Math.multiplyExact(mValues[m], mValues[m]); 
							}
							if (results[i] < temp) {
								results[i] = temp;
							}
						}
						//채집 불가능
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
