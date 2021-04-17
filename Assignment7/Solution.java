
import java.util.ArrayList;
import java.util.List;

public class Solution {
    //question 1
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        int[][] rotatedMatrix = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                rotatedMatrix[i][j] = matrix[(l - 1) - j][i];
            }
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                matrix[i][j] = rotatedMatrix[i][j];
            }
        }
    }

    //question 2
    public String reverseWords(String s) {
        s = s.trim();
        String [] arr = s.split("\\s+");
        String result = "";
        for(String i : arr){
            result = i + " " + result;
        }
        return result.substring(0, result.length() - 1);
    }

    //question 3
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public void setZeroes(int[][] matrix) {
        List<Pair> pair = new ArrayList<>();
        for(int i = 0;i < matrix.length; i++){
            for(int j = 0;j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    pair.add(new Pair(i,j));
                }
            }
        }

        for(Pair p: pair){
            for(int r = 0; r < matrix[0].length; r++){
                matrix[p.i][r]=0;
            }
            for(int r= 0; r< matrix.length; r++){
                matrix[r][p.j]=0;
            }
        }
    }

    //question 4
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] occurance = new int[26];
        ArrayList<Integer> arr = new ArrayList<>(26);
        for(char ch : s.toCharArray()){
            occurance[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            occurance[ch - 'a']--;
            if(occurance[ch - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    //question 5
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int minimium = Integer.MAX_VALUE;

        for (String string : strs)
            minimium = Math.min(minimium, string.length());

        int low = 1;
        int high = minimium;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}
