import java.util.ArrayList;
import java.util.HashSet;

public class Readme {
    public static void main(String[] args) {
        System.out.println("This is a readme file for Arrays and Hashing");
        HashSet<String> hs =  new HashSet<>();
        ArrayList<Integer> ar = new ArrayList<>();

        ar.add(1);
        ar.add(1,2);
        ar.add(2,3);
        String s = ar.toString();
        System.out.println(s);
        // System.out.println(ar.toString());
    }
}
