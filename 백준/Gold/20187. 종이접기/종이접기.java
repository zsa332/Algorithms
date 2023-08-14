import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] M;
    static String[] J;
    static int[] C;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // k 입력
        int k = Integer.parseInt(st.nextToken());
        
        // 손수건 접는 정보을 담은 배열
        J = new String[2*k];
        
        // 접는 정보 입력
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            J[idx++] = st.nextToken();
        }
        
        // 구멍 뚫는 번호 입력
        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        
        // 손수건의 각 위치를 돌며
        for (int i=0; i<Math.pow(2, k); i++) {
            for (int j=0; j<Math.pow(2, k); j++) {
                
                // 현 위치 위치 정보
                int x = j, y = i;
                
                // 손수건의 처음과 끝 위치 정보
                int startX = 0, endX = (int) (Math.pow(2, k)-1), startY = 0, endY = (int) (Math.pow(2, k)-1);
                
                // 현 위치의 구멍 번호 상태
                C = new int[] {0, 1, 2, 3};
                
                // 접는 정보를 순서대로 체크
                for (int p=0; p<2*k; p++) {
                    
                    // 오른쪽으로 접기
                    if (J[p].contains("R")) {
                        // 위치가 바뀌는 범위면 연산을 수행 후 위치를 update! 
                        if (x>=startX && x<=(startX+endX)/2) {
                            operationLR();
                            x = (startX+endX)/2 + (startX+endX)/2-x+1;
                        }
                        startX = (startX+endX)/2+1;
                    }
                    
                    // 왼쪽으로 접기
                    else if(J[p].contains("L")) {
                        // 위치가 바뀌는 범위면 연산을 수행 후 위치를 update! 
                        if (x>(startX+endX)/2 && x<=endX) {
                            operationLR();
                            x = (startX+endX)/2 + (startX+endX)/2-x+1;
                        }
                        endX = (startX+endX)/2;
                    }
                    
                    // 아래로 접기
                    else if (J[p].contains("D")) {
                        // 위치가 바뀌는 범위면 연산을 수행 후 위치를 update!
                        if (y>=startY && y<=(startY+endY)/2) {
                            operationUD();
                            y = (startY+endY)/2 + (startY+endY)/2-y+1;
                        }
                        startY = (startY+endY)/2+1;
                    }
                    
                    // 위로 접기
                    else if (J[p].contains("U")) {
                        // 위치가 바뀌는 범위면 연산을 수행 후 위치를 update!
                        if (y>(startY+endY)/2 && y<=endY) {
                            operationUD();
                            y = (startY+endY)/2 + (startY+endY)/2-y+1;
                        }
                        endY = (startY+endY)/2;
                    }
                    
                }
                
                // 구멍 출력
                System.out.print(C[number] + " ");

            }
            System.out.println();
        }
        
    }
    
    // 좌, 우로 접으면  (0, 2) <-> (1, 3)
    static void operationLR() {
        int temp1 = C[1];
        int temp2 = C[3];
        
        C[1] = C[0];
        C[3] = C[2];
        C[0] = temp1;
        C[2] = temp2;
    }
    
    
    // 상, 하로 접으면 (0, 1) <-> (2, 3)
    static void operationUD() {
        int temp1 = C[2];
        int temp2 = C[3];
        
        C[2] = C[0];
        C[3] = C[1];
        C[0] = temp1;
        C[1] = temp2;
    }

}