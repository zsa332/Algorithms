import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Madal> madalList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int countryCode = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            madalList.add(new Madal(countryCode, gold, silver, bronze));
        }

        Collections.sort(madalList);
        madalList.get(0).rank = 1;

        for(int i = 1; i <= madalList.size(); i++){
            if(madalList.get(i-1).countryCode == K) {
                System.out.println(madalList.get(i-1).rank);
                break;
            }

            if(madalList.get(i-1).gold == madalList.get(i).gold && madalList.get(i-1).silver == madalList.get(i).silver && madalList.get(i-1).bronze == madalList.get(i).bronze){
                madalList.get(i).rank = madalList.get(i - 1).rank;
            }
            else madalList.get(i).rank = madalList.get(i - 1).rank + 1;
        }
    }

    static class Madal implements Comparable<Madal>{
        int countryCode;
        int gold;
        int silver;
        int bronze;
        int rank;

        public Madal(int countryCode, int gold, int silver, int bronze) {
            this.countryCode = countryCode;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Madal m) {
            if(this.gold == m.gold){
                if(this.silver == m.silver)
                    return m.bronze - this.bronze;
                return m.silver - this.silver;
            }
            return m.gold - this.gold;
        }
    }
}
