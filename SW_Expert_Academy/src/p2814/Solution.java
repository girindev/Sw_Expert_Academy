package p2814;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int N, M;
    static ArrayList<ArrayList<Integer>> list;
    static int cnt = 1;
    static int ansList[];
    
    static int dfs(int x, int cnt, boolean chk[]){
        int result = cnt;
        chk[x] = true;
        for (int i=0; i<list.get(x).size(); i++) {
        	if (chk[list.get(x).get(i)] == false) {
        		boolean chkCopy[] = new boolean[N+1];
        		System.arraycopy(chk, 0, chkCopy, 0, chk.length);
        		chkCopy[list.get(x).get(i)] = true;
        		int temp = dfs(list.get(x).get(i), cnt+1, chkCopy);
        		if (temp > result) {
        			result = temp;
        		}
        	}
        }
        return result;
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    	int T = Integer.parseInt(st.nextToken());
    	ansList = new int[T];
        for (int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
        	for (int n=0 ;n<=N; n++){
            	list.add(new ArrayList<>());
            }
            for (int m=0; m<M; m++){
            	st = new StringTokenizer(br.readLine());
                int x =  Integer.parseInt(st.nextToken());
                int y =  Integer.parseInt(st.nextToken());
                
                list.get(x).add(y);
                list.get(y).add(x);
            }
            int ans = 0;
            for (int n=1; n<=N; n++) {
            	boolean chk[] = new boolean[N+1];
            	int temp = dfs(n, 1, chk);
            	if (temp > ans) {
            		ans = temp;
            	}
            }
            ansList[t] = ans;
        }
        for (int i=0; i<T; i++) {
        	System.out.println("#"+(i+1)+ " " + ansList[i]);
        }
    }
}