package Assignment8;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        String string = "";

        HashMap<String,Integer> map = new HashMap<>();
        map.put(beginWord,1);

        List<String> list1 = new LinkedList<String>();
        List<String> list2 = new LinkedList<String>();

        list1.add(beginWord);
        int len = beginWord.length(), misMatch = 0, size = 1;

        while(size != 0) {
            string = list1.get(0);
            for(String s1 : wordList) {
                if(map.containsKey(s1)) continue;
                for(int i = 0 ; i < len ; i++) {
                    if(string.charAt(i) != s1.charAt(i)) misMatch++;
                    if(misMatch > 1) break;
                }
                if(misMatch == 1) {
                    map.put(s1,map.get(string)+1);
                    if(s1.equals(endWord)) return map.get(s1);
                    list2.add(s1);
                }
                misMatch = 0;
            }

            list1.remove(0);
            size--;

            if(size == 0) {
                list1.addAll(list2);
                size = list1.size();
                list2.clear();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(wl.ladderLength("hit", "cog", wordList));
    }
}
