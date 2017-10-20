package p1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int charges[];
	static int schedule[];
	static int d[];
	static int count = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			charges = new int[5];
			schedule = new int[13];
			d = new int[13];
			for (int c = 1; c < 5; c++) {
				charges[c] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int s = 1; s < 13; s++) {
				schedule[s] = Integer.parseInt(st.nextToken());
				d[s] = schedule[s] * charges[1];
				if (d[s] > charges[2]) {
					d[s] = charges[2];
				}
			}
			
			while (true) {
				int result = 0;
				int idx = 0;
				for (int i = 1; i < 11; i++) {
					int tempResult = 0;
					if (schedule[i] != -1 && schedule[i + 1] != -1 && schedule[i + 2] != -1) {
						tempResult = d[i] + d[i + 1] + d[i + 2];
					}
					if (tempResult > result) {
						idx = i;
						result = tempResult;
					}
				}
				if (result > charges[3]) {
					for (int i=0; i<3; i++) {
						schedule[idx + i] = -1;	
						d[idx+i] = 0;
					}
					d[idx] = charges[3];
				} else {
					break;
				}
			}
			int ans = 0;
			for (int i : d) {
				ans += i;
			}
			if (ans > charges[3] * 4) {
				ans = charges[3] * 4;
			}
			if (ans > charges[4])
				ans = charges[4];
			System.out.println("#" + count + " " + ans);
			count++;
		}
	}
}
