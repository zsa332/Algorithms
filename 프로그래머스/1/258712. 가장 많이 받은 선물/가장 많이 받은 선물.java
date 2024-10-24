import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> giftMap = new HashMap<>();
        
        String[] friend = new String[2];
        for(int i = 0; i < gifts.length; i++){
            giftMap.put(gifts[i], giftMap.getOrDefault(gifts[i], 0) + 1);
            friend = gifts[i].split(" ");
            giftMap.put(friend[0], giftMap.getOrDefault(friend[0], 0) + 1);
            giftMap.put(friend[1], giftMap.getOrDefault(friend[1], 0) - 1);
        }
        
        int fNum = friends.length;
        int[] receive = new int[fNum];
        
        for(int i = 0; i < fNum; i++){
            for(int j = i + 1; j < fNum; j++){
                String key = friends[i] + " " + friends[j];
                String rKey = friends[j] + " " + friends[i];
                
                int gift = giftMap.getOrDefault(key, 0);
                int rGift = giftMap.getOrDefault(rKey, 0);
                if(gift > rGift)receive[i]++;
                else if(gift < rGift)receive[j]++;
                else {
                    int giftScoreA = giftMap.getOrDefault(friends[i], 0);
                    int giftScoreB = giftMap.getOrDefault(friends[j], 0);
                    if(giftScoreA > giftScoreB)receive[i]++;
                    else if(giftScoreA < giftScoreB) receive[j]++;
                }
            }
        }
        
        for(int i = 0; i < fNum; i++){
            answer = Math.max(answer, receive[i]);
        }
        
        return answer;
    }
}