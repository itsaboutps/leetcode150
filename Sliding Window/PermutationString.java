

public class PermutationString {
    public static void main(String[] args) {
        System.out.println("Permutation in String");
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.print(myApproach(s1, s2));
        System.out.println(mostOptimisedApproach(s1, s2));
    }

    private static boolean mostOptimisedApproach(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1>len2){
            return false;
        }
        char[] s1Count = new char[26];
        char[] s2Count = new char[26];

        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'A']++;
            s2Count[s2.charAt(i) - 'A']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if(s1Count[i]==s2Count[i]){
                matches+=1;
            }
        }
        int l = 0;
        for (int r = len1; r < len2; r++) {
            if(matches == 26){
                return true;
            }
            int index = s2.charAt(r) - 'a';
            s2Count[index]+=1;
            if(s1Count[index] == s2Count[index]){
                matches++;
            }else if(s1Count[index]+1 == s2Count[index]){
                matches-=1;
            }


             index = s2.charAt(l) - 'a';
            s2Count[index]-=1;
            if(s1Count[index] == s2Count[index]){
                matches++;
            }else if(s1Count[index]-1 == s2Count[index]){
                matches-=1;
            }
            l+=1;
        }
        return false;

    }

    private static boolean myApproach(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;

    }
}
