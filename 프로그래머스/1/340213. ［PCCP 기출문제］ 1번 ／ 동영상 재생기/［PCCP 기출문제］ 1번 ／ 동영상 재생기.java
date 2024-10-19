class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = stringToInt(video_len);
        int opStart = stringToInt(op_start);
        int opEnd = stringToInt(op_end);
        int cur = stringToInt(pos);
        
        for(String com : commands){
            if(opStart <= cur && cur <= opEnd)
                cur = opEnd;
            switch(com) {  
                case "prev":
                    cur = prevPos(cur);
                    break;
                case "next":
                    cur = nextPos(videoLen, cur, opStart, opEnd);
                    break;
            }
        }
        
        if(opStart <= cur && cur <= opEnd)
                cur = opEnd;
        
        return intToString(cur);
    }
    
    public int stringToInt(String time){
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
    public String intToString(int time){
        return (time / 60 < 10 ? "0" : "") + time / 60 + ":" + (time % 60 < 10 ? "0" : "") + time % 60;
    }
    
    public int prevPos(int cur){
        if(cur < 10)
            cur = 0;
        else cur -= 10;
        
        return cur;
    }
    
    public int nextPos(int videoLen, int cur, int opStart, int opEnd){
        if(videoLen - cur < 10)
            cur = videoLen;
        else cur += 10;
        
        return cur;
    }
}