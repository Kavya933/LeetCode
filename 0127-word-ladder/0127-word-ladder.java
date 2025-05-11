class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> track = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        track.add(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!track.isEmpty()){
            Pair pair = track.poll();
            String word = pair.word;
            int level = pair.level;

            if(word.equals(endWord)){
                return level;
            }
           
            for( int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] wordCharArray = word.toCharArray();
                    wordCharArray[i] = ch;
                    String modifiedWord = new String(wordCharArray);
                    if(set.contains(modifiedWord)){
                        set.remove(modifiedWord);
                        track.add(new Pair(modifiedWord,level+1));
                    }
                }
            }
        }
        return 0;
    }
    class Pair{
        String word;
        int level;
        Pair(String word, int level){
            this.word = word;
            this.level = level;
        }
    }
}