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
	static int task_a[]; // ���� â��
	static boolean chk_a[]; // ���� â��
	static int time_a[]; // ���� ���� �ð�

	static int task_b[]; // ���� â��
	static boolean chk_b[]; // ���� â��
	static int time_b[]; // ���� ���� �ð�
	static int count = 1;
	static List<Person> remainP; // ��� �����ð�

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
			while (true) { // ��� ����� ó���� ��
				if (remainPeopleCount == 0) {
					break;
				} else {
					// �ð��� ���� ��� �߰�
					for (int k = 0; k < K; k++) {
						if (tt == remainP.get(k).reach_time) {
							waitingA.add(remainP.get(k));
						}
					}
				}
				// ���� â�� ó��
				for (int n = 0; n < N; n++) {
					time_a[n] -= 1;
					if (time_a[n] == 0) {
						chk_a[n] = false;
						// ���⼭ b�� �Ѱ������
						waitingB.add(nowTaskA.get(n));
						nowTaskA.remove(n);
						time_a[n] = -1;
					}
					
					if (chk_a[n] == false && !waitingA.isEmpty()) { // ���� ��
						// ���� ����߿� �ش� �ð��� ������ ����� ���� ���
						nowTaskA.put(n, waitingA.get(0));
						remainP.get(waitingA.get(0).idx).a = n;
						waitingA.remove(0);
						time_a[n] = task_a[n]; // �ð� üũ
						chk_a[n] = true; // ���� ��
					}
				}
				// ���� â�� ó��
				for (int m = 0; m < M; m++) {
					time_b[m] -= 1;
					if (time_b[m] == 0) {
						chk_b[m] = false;
						// ���� ������ ����ֱ�
						nowTaskB.remove(m);
						remainPeopleCount--;
						time_b[m] = -1;
					}
					
					if (chk_b[m] == false && !waitingB.isEmpty()) { // ������
						nowTaskB.put(m, waitingB.get(0)); // �� �ջ��
						remainP.get(waitingB.get(0).idx).b = m;
						waitingB.remove(0);
						time_b[m] = task_b[m];// �ð�üũ
						chk_b[m] = true;// ������
					}
				}

				tt++; // �ð� ����
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
