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
				charges[i] = Integer.parseInt(st.nextToken()); // ���ǥ
			}
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<13; i++) {
				schedules[i] = Integer.parseInt(st.nextToken()); // ���� ����
				schCharges[i] = schedules[i] * charges[0]; // ��� 1�ϱ����� �� ��
				if (schCharges[i] > charges[1]) {
					schCharges[i] = charges[1]; //1�ϱ� �߿� 1�޺��� �ݾ��� ū ���
				}
			}
			
			for (int i=1; i<13; i++) {
				
			}
		}
	}
}
