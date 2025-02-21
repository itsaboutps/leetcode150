public class LongestRepeatingCharacter {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        // longestRepeatingCharacterReplacement(s,k);

        System.out.print(slidingWindow(s, k));
    }

    private static int slidingWindow(String s, int k) {
        int N = s.length();
        int[] char_counts = new int[26];
        int windows_start = 0;
        int max_length = 0;
        int max_count = 0;

        for (int windows_end = 0; windows_end < N; windows_end++) {
            char_counts[s.charAt(windows_end) - 'A']++;
            max_count = Math.max(max_count, char_counts[s.charAt(windows_end) - 'A']);

            while (windows_end - windows_start - max_count + 1 > k) {
                char_counts[s.charAt(windows_start) - 'A']--;
                windows_start++;
            }

            max_length = Math.max(max_length, windows_end - windows_start + 1);
        }

        return max_length;
    }

    // private static void longestRepeatingCharacterReplacement(String s, int k) {
    //     int l = 0;
    //     int r = 0;
    //     int diff = 0;
    //     int maxLen = 0;

    //     while (r < s.length()) {
    //         if (s.charAt(l) == s.charAt(r)) {
    //             maxLen = Math.max(maxLen, r - l + 1);
    //             r += 1;
    //         } else {
    //             if (diff < k) {
    //                 diff++;
    //                 maxLen = Math.max(maxLen, r - l + 1);
    //                 r += 1;

    //             } else {
    //                 l = r;
    //                 r += 1;
    //             }
    //         }
    //     }
    //     System.out.println(maxLen);
    // }
}
