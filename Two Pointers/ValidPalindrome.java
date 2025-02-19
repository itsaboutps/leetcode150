public class ValidPalindrome {
    public static void main(String[] args) {
        String s0 = "A man, a plan, a canal: Panama";
        String s1 = "0P";
        // System.out.println(f(s1));
        // System.out.println(g(s0));

        //two pointers approach 
        System.out.println(k(s0));

    }

    private static boolean f(String s) {
        if(s.length()<=0){
            return true;
        }
        String inputString = "";
        for(char c : s.toCharArray()){
            if((c>=65 && c<=90) || (c>=97 && c<=122) || (c<=57 && c>=48)){
                inputString = inputString+String.valueOf(c).toLowerCase(); 
            }
        }
        int len = inputString.length();
        for (int i = 0; i < inputString.length(); i++) {
            if(inputString.charAt(i) == inputString.charAt(len-i-1)){

            }else{
                return false;
            }
        }
        return true;
    }

    private static boolean g(String s) {
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            //! way to check alphanumeric in java 
            if (Character.isLetterOrDigit(c)) {
                newStr.append(Character.toLowerCase(c));
            }
        }
        return newStr.toString().equals(newStr.reverse().toString());
    }

    //* two pointers approach
    private static boolean k(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !alphaNum(s.charAt(l))) {
                l++;
            }
            while (r > l && !alphaNum(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++; r--;
        }
        return true;
    }

    public static boolean  alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' || 
                c >= 'a' && c <= 'z' || 
                c >= '0' && c <= '9');
    }

}
