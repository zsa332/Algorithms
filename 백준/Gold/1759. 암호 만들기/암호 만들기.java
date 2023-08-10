import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L, C;
    static char[] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        String str = br.readLine().replace(" ", "");
        chars = str.toCharArray();

        Arrays.sort(chars);

        combination(0, 0, 0, "");
    }

    private static void combination(int start , int cnt, int flag, String password){
        if(cnt == L){
            int vowel = 0, consonant = 0;
            for(int i = 0; i < password.length(); i++){
                if(password.charAt(i) =='a' || password.charAt(i) =='e' || password.charAt(i) =='i'
                        || password.charAt(i) =='o' || password.charAt(i) =='u')vowel++;
                else consonant++;
            }
            if(vowel >= 1 && consonant >= 2)
                System.out.println(password);
            return;
        }

        for(int i = start; i < C; i++){
            if((flag & 1 << i) != 0) continue;
            combination(i+1, cnt+1, flag | 1 << i, password + chars[i]);
        }
    }
    private static boolean np(int[] mask) {
        // 1. 꼭지점을 탐색
        int N = mask.length;
        int i = N - 1;
        while(i > 0 && mask[i-1] >= mask[i])i--;

        if(i == 0)return false; // 꼭지점이 첫번째인 경우 더이상의 경우의 수 없음

        // 2. 꼭지점전 값과 바꿀 한단계 높은 값을 탐색
        int j = N - 1;
        while(mask[i-1] >= mask[j])j--;

        // 3. 교체
        swap(mask, i-1, j);

        // 4. 꼭지점 이후의 값을 오름차순 정렬
        while(i < j){
            swap(mask, i++, j--);
        }

        return true;
    }

    private static void swap(int[] mask, int i, int j) {
        int temp = mask[i];
        mask[i] = mask[j];
        mask[j] = temp;
    }
}
