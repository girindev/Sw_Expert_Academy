package p1209Sum;

import java.util.Scanner;

/**
 * @author  : 박성훈
 * @create  : 2017-11-07
 * @success : ok
 * @comment : 1209. [S/W 문제해결 기본] 2일차 - Sum (d3)
 */
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int trash = in.nextInt();
			int n[][] = new int[100][100];
			for (int i=0; i<100; i++) {
				for (int j=0; j<100; j++) {
					n[i][j] = in.nextInt();
				}	
			}
			
			int max = 0;
			int sum_row = 0;
			int sum_col = 0;
			for (int i=0; i<100; i++) {
				sum_row = 0;
				sum_col = 0;
				for (int j=0; j<100; j++) {
					sum_row += n[i][j];
					sum_col += n[j][i];
				}
				max = Math.max(max, Math.max(sum_row, sum_col));
			}
			int sum_diagonal1=0;
			int sum_diagonal2=0;
			for (int i=0; i<100; i++) {
				sum_diagonal1 += n[i][i];
				sum_diagonal2 += n[i][99-i];
			}
			System.out.println("#"+(t+1)+" " + Math.max(max, Math.max(sum_diagonal1, sum_diagonal2)));
		}
	}
}
