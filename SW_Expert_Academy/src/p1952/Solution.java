package p1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] charges;
	static int[] schedules;
	static int[] schCharges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			charges = new int[4];
			schedules = new int[12];
			schCharges = new int[12];
			for (int i=0; i<4; i++) {
				charges[i] = Integer.parseInt(st.nextToken()); // 요금표
			}
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<13; i++) {
				schedules[i] = Integer.parseInt(st.nextToken()); // 수영 일정
				schCharges[i] = schedules[i] * charges[0]; // 모두 1일권으로 할 때
				if (schCharges[i] > charges[1]) {
					schCharges[i] = charges[1]; //1일권 중에 1달보다 금액이 큰 경우
				}
			}
			
			for (int i=1; i<13; i++) {
				
			}
		}
	}
}
