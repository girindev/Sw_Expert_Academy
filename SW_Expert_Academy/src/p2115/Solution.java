package p2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int map[][];
	static boolean chk[][];
	static int i = 1;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스
		int results[] = null;
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
			results = new int[2];
			int mValues[] = new int[M];
			chk = new boolean[N][N];
			for (int i = 0; i < 2; i++) {
				int copy_n1[] = new int[M];
				int copy_n2[] = new int[M];
				for (int n1 = 0; n1 < N; n1++) {
					for (int n2 = 0; n2 < N - M + 1; n2++) {
						int sum = 0;
						for (int m = 0; m < M; m++) {
							mValues[m] = map[n1][n2 + m];
							copy_n1[m] = n1;
							copy_n2[m] = n2 + m;
							sum += mValues[m];
						}
						for (int m1 = 0; m1 < M; m1++) {
							if (map[copy_n1[m1]][copy_n2[m1]] == 0) {
								sum = 0;
							}
						}
						if (sum != 0) {
							// 채집 가능
							if (sum <= C) {
								int temp = 0;
								for (int m = 0; m < M; m++) {
									temp += Math.multiplyExact(mValues[m], mValues[m]);
								}
								if (results[i] < temp) {
									results[i] = temp;
									for (int q = 0; q < N; q++) {
										for (int j = 0; j < N; j++) {
											chk[q][j] = false;
										}
									}
									for (int m = 0; m < M; m++) {
										chk[copy_n1[m]][copy_n2[m]] = true;
									}
								}
							}
							// 채집 불가능
							if (sum > C) {
								int temp1[] = new int[mValues.length];
								int temp2[] = new int[mValues.length];
								int tempSum = 0;
								int tempResult = 0;
								int result = 0;
								int tempMultiSum = 0;
								Arrays.sort(mValues);
								for (int r = 0; r < mValues.length; r++) {
									tempSum = 0;
									tempMultiSum = 0;
									temp1 = new int[mValues.length];
									for (int l = mValues.length - 1 - r; l >= 0; l--) {
										
										if (tempSum + mValues[l] <= C) {
											temp1[l] = mValues[l];
											tempSum += mValues[l];
											tempMultiSum += mValues[l]*mValues[l];
										}
									} 
									if (tempResult < tempMultiSum) { 
										tempResult = tempMultiSum;
										for (int z=0; z<mValues.length; z++) {
											temp2[z] = temp1[z];
										}
									}
								}
								for (int v : temp2) {
									result += (v * v);
								}
								if (results[i] < result) {
									results[i] = result;
									for (int q = 0; q < N; q++) {
										for (int w = 0; w < N; w++) {
											chk[q][w] = false;
										}
									}
									for (int m1 = 0; m1 < M; m1++) {
										chk[copy_n1[m1]][copy_n2[m1]] = true;
									}
								}
							}
						}
					}
				}
				for (int k = 0; k < N; k++) {
					for (int h = 0; h < N; h++) {
						if (chk[k][h] == true) {
							map[k][h] = 0;
						}
					}
				}
			}
			int ans = 0;
			for (int r : results) {
				ans += r;
				System.out.println("#"+ i+ " "+ r);
			}
//			System.out.println("#"+ i+ " "+ ans);
			i++;
		}
	}
}