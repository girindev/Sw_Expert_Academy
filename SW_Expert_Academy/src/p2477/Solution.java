package p2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int M;
	static int K;
	static int A;
	static int B;
	static int task_a[]; // 접수 창구
	static boolean chk_a[]; // 접수 창구
	static int time_a[]; // 남은 업무 시간

	static int task_b[]; // 정비 창구
	static boolean chk_b[]; // 정비 창구
	static int time_b[]; // 남은 업무 시간
	static int count = 1;
	static List<Person> remainP; // 사람 도착시간

	static class Person {
		int reach_time;
		int a;
		int b;
		int idx;

		public Person(int reach_time, int a, int b, int idx) {
			this.reach_time = reach_time;
			this.a = a;
			this.b = b;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			task_a = new int[N];
			task_b = new int[M];
			remainP = new ArrayList<>();
			chk_a = new boolean[N];
			chk_b = new boolean[M];

			time_a = new int[N];
			time_b = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int ta = 0; ta < N; ta++) {
				task_a[ta] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int tb = 0; tb < M; tb++) {
				task_b[tb] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int rp = 0; rp < K; rp++) {
				remainP.add(new Person(Integer.parseInt(st.nextToken()), -1, -1, rp));
			}
			int tt = 0; // time
//			ArrayList<Person> nowTaskA = new ArrayList<>();
//			ArrayList<Person> nowTaskB = new ArrayList<>();
			Map<Integer, Person> nowTaskA = new HashMap<>();
			Map<Integer, Person> nowTaskB = new HashMap<>();
			ArrayList<Person> waitingA = new ArrayList<>();
			ArrayList<Person> waitingB = new ArrayList<>();
			int remainPeopleCount = K;
			while (true) { // 모든 사람이 처리될 때
				if (remainPeopleCount == 0) {
					break;
				} else {
					// 시간에 따라 사람 추가
					for (int k = 0; k < K; k++) {
						if (tt == remainP.get(k).reach_time) {
							waitingA.add(remainP.get(k));
						}
					}
				}
				// 접수 창구 처리
				for (int n = 0; n < N; n++) {
					time_a[n] -= 1;
					if (time_a[n] == 0) {
						chk_a[n] = false;
						// 여기서 b로 넘겨줘야함
						waitingB.add(nowTaskA.get(n));
						nowTaskA.remove(n);
						time_a[n] = -1;
					}
					
					if (chk_a[n] == false && !waitingA.isEmpty()) { // 쉬는 중
						// 남은 사람중에 해당 시간에 도착한 사람이 있을 경우
						nowTaskA.put(n, waitingA.get(0));
						remainP.get(waitingA.get(0).idx).a = n;
						waitingA.remove(0);
						time_a[n] = task_a[n]; // 시간 체크
						chk_a[n] = true; // 업무 중
					}
				}
				// 정비 창구 처리
				for (int m = 0; m < M; m++) {
					time_b[m] -= 1;
					if (time_b[m] == 0) {
						chk_b[m] = false;
						// 업무 끝났음 비워주기
						nowTaskB.remove(m);
						remainPeopleCount--;
						time_b[m] = -1;
					}
					
					if (chk_b[m] == false && !waitingB.isEmpty()) { // 쉬는중
						nowTaskB.put(m, waitingB.get(0)); // 맨 앞사람
						remainP.get(waitingB.get(0).idx).b = m;
						waitingB.remove(0);
						time_b[m] = task_b[m];// 시간체크
						chk_b[m] = true;// 업무중
					}
				}

				tt++; // 시간 증가
			}
			int ans = 0;
			for (int i = 0; i < remainP.size(); i++) {
				if (remainP.get(i).a +1 == A && remainP.get(i).b+1 == B) {
					ans += (i+1);
				}
			}
			if (ans == 0)
				ans = -1;
			System.out.println("#"+ count + " " + ans);
			count++;
		}
	}
}
