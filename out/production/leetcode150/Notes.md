class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int s1Len = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            // Permutation in String
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int l =0;
        int r = s1Len;
        //
        while (r<s2.length()) {
            
            for ( int l1 = l; l1 < r; l1++) {
                map2.put(s2.charAt(l1), map2.getOrDefault(s2.charAt(l1), 0) + 1);
            }
            if(map1.equals(map2)){
                return true;   
            }
            map2.clear();

            l=r-1;
            r=r+s1Len -1;
        }
        return false;
    }
}