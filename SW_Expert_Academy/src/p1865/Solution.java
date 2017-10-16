package p1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static ArrayList<ArrayList<Integer>> sp; // 성공 확률
	static int[] maxValue;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
		 	int N = Integer.parseInt(st.nextToken());
			sp = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				sp.add(new ArrayList<>());
			}
			maxValue = new int[N];
			result = new int[N];
			// 확률 초기화
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int i=0; i<N; i++) {
					sp.get(n).add(Integer.parseInt(st.nextToken()));
				}
			}
			// 최대치
			while (!sp.isEmpty()) {
				int size = sp.size();
				maxValue = new int[size];
				for (int i = 0; i <size; i++) {
					int tmp = 0;
					for (int j : sp.get(i)){
						if (tmp < j) {
							tmp = j;
						}
					}
					maxValue[i] = tmp;
				}
				int max = 0;
				for (int i=0; i<size; i++) {
					if (max < maxValue[i]) {
						max = maxValue[i];
					}
				}
				for (int i=0; i<size; i++) {
					boolean flag = false;
					int s = sp.get(i).size();
					for (int j=0; j<s; j++) {
						int v = sp.get(i).get(j); 
						if (v== max) {
							result[i] = max;
							flag = true;
							break;
						}
					}
					if (flag == true) {
						sp.remove(i);
						for (int k=0; k<sp.size(); k++) {
							sp.get(k).remove(i);
						}
					}
				}
			}
			for (int i : result) {
				System.out.println(i);
			}
		}
	}
}
