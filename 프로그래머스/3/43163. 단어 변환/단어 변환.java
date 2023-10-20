import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Word> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[words.length];
		
		queue.add(new Word(0, begin));
		while(!queue.isEmpty()) {
			Word cur = queue.poll();
			
			if(cur.w.equals(target)) {
				answer = cur.n;
			}
			for(int i = 0; i < words.length; i++) {
				int cnt = 0;
				for(int j = 0; j < cur.w.length(); j++) {
					if(cur.w.charAt(j) != words[i].charAt(j))cnt++;
				}
				if(cnt != 1 || visited[i]) continue;
				visited[i] = true;
				queue.add(new Word(cur.n + 1, words[i]));
			}
		}
        return answer;
    }
    	static class Word{
		int n;
		String w;
		public Word(int n, String w) {
			this.n = n;
			this.w = w;
		}
	}
}