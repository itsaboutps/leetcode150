import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        String s = "car";
        String t = "rat";
        // System.out.println(isAnagramMp(s, t));
        System.out.println(isAnagramSort(s, t));
    }

    // more optimised compare to other one
    private static boolean isAnagramSort(String s, String t) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        String s1 = new String(charArr);
        char[] charrArr1 = t.toCharArray();
        Arrays.sort(charrArr1);
        String s2 = new String(charrArr1);

        return s1.equals(s2);
    }

    // space complexity O(n)
    // also we can do using sort the both and compare
    public static boolean isAnagramMp(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return mapS.equals(mapT);
    }
}