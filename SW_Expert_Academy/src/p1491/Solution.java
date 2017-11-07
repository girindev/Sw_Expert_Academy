package p1491;

import java.util.Scanner;
/**
 * @author  : 박성훈
 * @create  : 2017-11-07
 * @success : ok
 * @comment : 1491. 원재의 벽 꾸미기 (d3)
 */
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			int A = in.nextInt();
			int B = in.nextInt();
			// A x lR-Cl + B x (N- R*C)
			long min = Integer.MAX_VALUE;
			for (int n = 1; n <= N/2; n++) {
				long r = n;
				for (int n2 = n; n2 <= N; n2++) {
					long c = n2;
					if (r * c > N)
						break;
					min = Math.min(min, (A * Math.abs(r - c)) + B * (N - (r * c)));
				}
			}
			System.out.println("#"+(t+1)+" " + min);
		}
	}
}
