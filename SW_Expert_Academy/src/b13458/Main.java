package b13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//시험감독 완료
public class Main {
	static int N; // 시험장
	static int A[]; // 응시생
	static int B;
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long result = 0;
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		for (int n=0; n<N; n++) {
			result += 1;
			if (A[n] > B) {
				A[n] -= B;
				result += A[n]/C;
				if (A[n]%C != 0) {
					result +=1;
				}
			} 
		}
		System.out.println(result);
	}
}
