import java.util.*;

class Solution {
    private final static char[] alp = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        List<String> wordList = new ArrayList<>();
        
        makeWord("", wordList);
        
        return wordList.indexOf(word);
    }
    
    public void makeWord(String word, List<String> wordList){
        wordList.add(word);
        
        if(word.length() == 5)
            return;
        
        for(Character chr : alp){
            makeWord(word + chr, wordList);
        }
    }
}