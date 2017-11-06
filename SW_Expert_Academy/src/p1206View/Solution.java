package p1206View;

import java.util.Scanner;

/**
 * @author : 박성훈
 * @create : 2017-11-06
 * @success : ok
 * @comment : 1206. [S/W 문제해결 기본] 1일차 - View (d3)
 */
class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int N = in.nextInt();
			int ans = 0;
			int building[] = new int[N];
			for (int n = 0; n < N; n++) {
				building[n] = in.nextInt();
			}
			for (int i = 2; i < N - 2; i++) {
				int left1 = building[i] - building[i - 1];
				int left2 = building[i] - building[i - 2];
				int right1 = building[i] - building[i + 1];
				int right2 = building[i] - building[i + 2];
				if (left1 >= 1 && left2 >= 1 && right1 >= 1 && right2 >= 1) {
					ans += Math.min(left1, Math.min(left2, Math.min(right1, right2)));
					i += 2;
				}
			}
			System.out.println("#" + (t + 1) + " " + ans);
		}
	}
}
