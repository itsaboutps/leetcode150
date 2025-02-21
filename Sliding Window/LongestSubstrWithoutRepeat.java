import java.util.HashSet;
import java.util.Set;

public class LongestSubstrWithoutRepeat {
    public static void main(String[] args) {
        System.out.println("Longest Substring Without Repeating Characters ");
        String s = "zxyzxyz";

        // System.out.println(bruteForce(s));

        System.out.println(twoPointer(s));
    }

    private static int twoPointer(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;// sliding window
        int r = 0;
        int len = s.length();
        int result = 0;
        while (r < len) {
            while (set.contains(s.charAt(r))) {
                // dublicate case
                // now we have to update our window as well
                set.remove(s.charAt(l));
                l += 1;
            }
            set.add(s.charAt(r));
            result = Math.max(result, r - l + 1);
            r+=1;

        }
        return result;
    }

    private static int bruteForce(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) {
                    break;
                }
                charSet.add(s.charAt(j));
            }
            res = Math.max(res, charSet.size());
        }
        return res;
    }
}
