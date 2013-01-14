public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        s = s.toUpperCase();
        while (i < j) {
            Character a = s.charAt(i);
            Character b = s.charAt(j);
            if (!Character.isLetterOrDigit(a)) {
                i++;
            } else if (!Character.isLetterOrDigit(b)) {
                j--;
            } else if (!a.equals(b)) {
                return false;
            } else {
                i++;
                j--;    
            }
        }
        return true;
    }
}
