import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        int[] count = new int[26];
        int[] count2 = new int[26];

        for(char c : word1.toCharArray()){
            count[c - 'a']++;
        }

        for(char c : word2.toCharArray()){
            count2[c - 'a']++;
        }

        int answer = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] > 0 && count2[i] > 0){
                answer += Math.abs(count[i] - count2[i]);
            }
            else {
                answer += count[i];
                answer += count2[i];
            }
        }

        System.out.println(answer);
    }
}
