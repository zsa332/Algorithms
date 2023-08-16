import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Team[] records;
	static int[] Ateam = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] Bteam = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static boolean isPossible;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			records = new Team[6];
			for(int j = 0; j < 6; j++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());;
				int lose = Integer.parseInt(st.nextToken());;
				records[j] = new Team(win, lose, draw);
			}

			isPossible = false;
			dfs(0);
			
			if(isPossible)System.out.print(1 + " ");
			else System.out.print(0 + " ");
		}
		
	}
	
	private static void dfs(int cnt) {
		if(cnt == 15) {
			int sum = 0;
			for(Team t : records) {
				sum += t.win;
				sum += t.lose;
				sum += t.draw;
			}
			if(sum == 0)isPossible = true;
			return;
		}
		if(records[Ateam[cnt]].win > 0 && records[Bteam[cnt]].lose > 0) {
			records[Ateam[cnt]].win--;
			records[Bteam[cnt]].lose--;
			dfs(cnt+1);
			records[Ateam[cnt]].win++;
			records[Bteam[cnt]].lose++;
		}
		if(records[Ateam[cnt]].lose > 0 && records[Bteam[cnt]].win > 0) {
			records[Ateam[cnt]].lose--;
			records[Bteam[cnt]].win--;
			dfs(cnt+1);
			records[Ateam[cnt]].lose++;
			records[Bteam[cnt]].win++;
		}
		if(records[Ateam[cnt]].draw > 0 && records[Bteam[cnt]].draw > 0) {
			records[Ateam[cnt]].draw--;
			records[Bteam[cnt]].draw--;
			dfs(cnt+1);
			records[Ateam[cnt]].draw++;
			records[Bteam[cnt]].draw++;
		}
	}

}
class Team{
	int win;
	int lose;
	int draw;
	public Team(int win, int lose, int draw) {
		super();
		this.win = win;
		this.lose = lose;
		this.draw = draw;
	}
}
