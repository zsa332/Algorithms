import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
            
        while(!checkSize(wallet, bill)){
            fold(bill);
            answer++;
        }
        
        
        return answer;
    }
    
    public boolean checkSize(int[] wallet, int[] bill){
        Arrays.sort(wallet);
        Arrays.sort(bill);
        
        if(wallet[0] >= bill[0] && wallet[1] >= bill[1])
            return true;
        
        return false;
        
    }
    
    public void fold(int[] bill){
        if(bill[0] > bill[1])
            bill[0] /= 2;
        else bill[1] /= 2;
    }
}