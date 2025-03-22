// https://leetcode.com/problems/group-anagrams/description/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.print(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> mp = new HashMap<>();

        for(String s:strs){
            int[] count = new int[26];
            for(char c: s.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sb  = new StringBuilder();
            for(int i : count){
                sb.append("*");
                sb.append(i);
            }

            String generatedHashedKey = sb.toString();

            if(!mp.containsKey(generatedHashedKey)){
                mp.put(generatedHashedKey, new ArrayList<>());
            }
            mp.get(generatedHashedKey).add(s);
        }

        return new ArrayList(mp.values());
        
    }
}
