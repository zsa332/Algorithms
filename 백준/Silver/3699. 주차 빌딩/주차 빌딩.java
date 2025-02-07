import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        List<CarLocation> carBuilding;
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            carBuilding = new ArrayList<>();
            carBuilding.add(new CarLocation(0, 0, 0));
            for(int i = 0; i < H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < I; j++){
                    int carNum = Integer.parseInt(st.nextToken());
                    if(carNum != -1){
                        carBuilding.add(new CarLocation(i, j, carNum));
                    }
                }
            }

            Collections.sort(carBuilding);

            int totalTime = 0;
            int[] floorBeltNum = new int[H];
            for(int i = 1; i < carBuilding.size(); i++){
                CarLocation cur = carBuilding.get(i);

                totalTime += (cur.x) * 20;
                totalTime += checkDistance(floorBeltNum[cur.x], cur.y, I) * 5;
                floorBeltNum[cur.x] = cur.y;
            }

            System.out.println(totalTime);
        }
    }

    static public int checkDistance(int cur, int tar, int I){
        int leftDis = cur > tar ? cur - tar : Math.abs(cur + I - tar);
        int rightDis = cur > tar ? Math.abs(I - cur + tar) : tar - cur;
        return Math.min(leftDis, rightDis);
    }

    static class CarLocation implements Comparable<CarLocation> {
        int x;
        int y;
        int carNum;

        public CarLocation(int x, int y, int carNum) {
            this.x = x;
            this.y = y;
            this.carNum = carNum;
        }
        
        @Override
        public int compareTo(CarLocation c){
            return Integer.compare(this.carNum, c.carNum);
        }
    }
}
