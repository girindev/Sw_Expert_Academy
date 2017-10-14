package b14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
	static int N, M;
	static int Map[][];
	static int dx[] = {
					//////////// 일자
					0,0,0,1,2,3
					//////////
					
					////////////사각형
					,0,1,1 
					//////////
					
					/////////////// ㅜ ㅗ ㅓ ㅏ
					,0,0,1 ,0,0,-1 ,0,-1,1 , 1,2,1 
 					,1,1,2 ,1,1,2 ,0,1,1 ,0,-1,-1
					//////////
 					
 					/////////////L
 					,1,2,2 
 					,0,1,2
 					,0,0,-1
 					,-1,-1,-1
 					,0,-1,-2
 					,1,2,0
 					,1,1,1
 					,0,0,1
					////////////
				};
	
	static int dy[] = {
					/////////일자	
					 1,2,3,
					 0,0,0
					//////////
					 
					/////////사각형
					 ,1,0,1 
					//////////////
					 
					////////////////////// ㅗ ㅜ ㅓ ㅏ
					,1,2,1 ,1,2,1 ,1,1,1 , 0,0,1 
					,0,1,1 ,0,-1,-1 ,1,1,2 ,1,1,2
					//////////////
					
					///////////////L
					,0,0,1
					,1,1,1
					,1,2,2
					,0,1,2
					,1,1,1,
					0,0,1
					,0,1,2
					,1,2,2
					//////////////
				};
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new int[N][M];
		int result = 0;
		for (int n=0; n<N; n++){
			st = new StringTokenizer(br.readLine());
			for (int m=0; m<M; m++) {
				Map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		for (int n=0; n<N; n++){
			for (int m=0; m<M; m++) {
				for (int i=0; i<19; i++){
					boolean flag = true;
					int temp = Map[n][m];
					for (int j=i*3; j<=(i*3)+2; j++){
						int nx = n + dx[j];
						int ny = m + dy[j];
						if (0<=nx && nx<N && 0<=ny && ny<M) {
							temp += Map[nx][ny];
						} else {
							flag = false;
						}
					}
					if (flag == true) {
						if (result < temp) {
							result = temp;
						}
					}
				}
			}
		}
		System.out.println(result);
	} 
}
