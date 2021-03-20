package Assignment6;

import java.util.ArrayList;
import java.util.List;

public class question4 {
    /*
   question4
   */
    ArrayList<String> arr = new ArrayList<> ();

    public List<String> generateParenthesis(int n) {
        int size = n*2;

        char[] result = new char[size];
        int current = 0;
        combinations(result, current, "()");
        return arr;
    }

    private void combinations(char[] result, int current, String str) {
        if (current == result.length) {
            if (valid(result)){
                arr.add(new String(result));
                System.out.println(new String(result));
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            result[current] = str.charAt(i);
            combinations(result, current + 1, str);
        }
    }

    private boolean valid(char[] result){
        int num = 0;
        for(char c: result){
            if ( c == '('){
                num ++;
            } else if (c == ')'){
                num --;
            }

            if(num < 0) {
                return false;
            }
        }

        boolean wellFormed = false;
        if (num == 0) {
            wellFormed = true;
        }
        return wellFormed;
    }
}
