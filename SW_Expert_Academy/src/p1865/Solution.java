package p1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int [][] sp; //���� Ȯ��
	static int [] maxValue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			sp = new int[N+1][N+1];
			maxValue = new int[N+1];
			// Ȯ�� �ʱ�ȭ
			for (int n=1; n < N+1; n++) {
				st = new StringTokenizer(br.readLine());
				for (int i=1; i<N+1; i++){
					sp[i][n] = Integer.parseInt(st.nextToken());
				}
			}
			// �ִ�ġ
			while (true) {
				for (int i=1; i<N+1; i++) {
					 
				}
			}
		}
	}
}
