import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int type = Integer.parseInt(st.nextToken());
        String name = st.nextToken();

        String camelCase = "";
        String snakeCase = "";
        String pascalCase= "";
        switch (type){
            case 1 :
                camelCase = name;
                snakeCase = convertToSnake(name);;
                pascalCase = Character.toUpperCase(name.charAt(0)) + name.substring(1);
                break;

            case 2 :
                String[] words = name.split("_");
                for(int i = 0; i < words.length; i++){
                    pascalCase += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
                }
                snakeCase = name;
                camelCase = Character.toLowerCase(pascalCase.charAt(0)) + pascalCase.substring(1);
                break;

            case 3 :
                camelCase = Character.toLowerCase(name.charAt(0)) + name.substring(1);
                snakeCase = convertToSnake(name);
                pascalCase = name;
                break;

        }
        System.out.println(camelCase);
        System.out.println(snakeCase);
        System.out.println(pascalCase);
    }

    public static String convertToSnake(String name){
        String result = "" + Character.toLowerCase(name.charAt(0));
        for(int i = 1; i < name.length(); i++){
            if(name.charAt(i) >= 'A' && name.charAt(i) <= 'Z')
                result += "_" + Character.toLowerCase(name.charAt(i));
            else result += name.charAt(i);
        }

        return result;

    }
}
