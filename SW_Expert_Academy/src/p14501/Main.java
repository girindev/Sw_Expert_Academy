package p14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Pair> w;
	static int N;
	static class Pair {
		int t;
		int p;
		public Pair(int t, int p) {
			this.t= t;
			this.p = p;
		}
	}
	static int work(int day, boolean checkWork){
		int result = 0;
		if (checkWork == true) {
			result += work(N-w.get(day).t, true)+w.get(day).p; 
		} else {
			result += work(N-w.get(day).t, true)+w.get(day).p; 
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		w = new ArrayList<>();
		for (int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			w.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
	}
}