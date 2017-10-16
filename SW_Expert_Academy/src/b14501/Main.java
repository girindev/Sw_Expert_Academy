package b14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Schedule sch[];

	static class Schedule {
		int day;
		int t;
		int p;

		public Schedule(int day, int t, int p) {
			this.day = day;
			this.t = t;
			this.p = p;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sch = new Schedule[N + 1];

		for (int n = 1; n < N + 1; n++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			sch[n] = new Schedule(n, t, p);
		}

		int dp[] = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			// 일을 할 수 있는 조건
			if (sch[i].day + sch[i].t <= N+1) {
				// 전날 스케줄이 1일결우
				int before_day_value = 0;
				for (int j = i - 1; j > 0; j--) {
					if (sch[j].day + sch[j].t <= sch[i].day) {
						if (before_day_value < dp[j]) {
							before_day_value = dp[j];
						}
					}
				}
				dp[i] =  before_day_value + sch[i].p;
			}
		}
		int ans = 0;
		for (int i : dp) 
			if (i > ans) ans = i;
		System.out.println(ans);
	}
}
