package p1208Flatten;

import java.util.Scanner;

/**
 * @author : 박성훈
 * @create : 2017-11-06
 * @success : ok
 * @comment : 1208. [S/W 문제해결 기본] 1일차 - Flatten (d3)
 */
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int t = 0; t < 1; t++) {
			int N = in.nextInt();
			int box[] = new int[100];
			for (int n = 0; n < 100; n++) {
				box[n] = in.nextInt();
			}
			int max_idx = 0;
			int min_idx = 0;
			int max = 0;
			int min = 0;
			for (int n = 0; n < N; n++) {
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				for (int i = 0; i < 100; i++) {
					if (max < box[i]) {
						max = box[i];
						max_idx = i;
					} 
					if (min > box[i]) {
						min = box[i];
						min_idx = i;
					}
				}
				box[max_idx] = box[max_idx]-1;
				box[min_idx] = box[min_idx]+1;
				if (box[max_idx] - box[min_idx] <= 1) {
					break;
				}
			}
			int m = 0;
			int n = 101;
			for (int i=0; i<100; i++) {
				if (box[i] > m) {
					m = box[i];
				}
				if (box[i] < n) {
					n = box[i];
				}
			}
			System.out.println("#" + (t+1) + " " + (m-n));
		}
	}
}
