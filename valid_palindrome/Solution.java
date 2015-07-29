package valid_palindrome;
public class Solution {
    public boolean isPalindrome(String s) {
        String p = s.toLowerCase().replaceAll("[^a-z0-9]","");
        for(int i=0, j=p.length()-1; i<j; i++, j--) {
            if (p.charAt(i)!=p.charAt(j)){
                return false;
            }
        }
        return true;
    }
}