import java.util.ArrayList;

public class RestoreIPAddresses {
    private boolean isValidIPNum(String s) {
        try {
            if (!s.startsWith("0") || s.length() == 1) {
                int num = Integer.parseInt(s);
                if (num >= 0 && num <= 255) return true;
            }
        } catch (Exception e) {}
        return false;
    }
    
    private ArrayList<String> halfIP(String s) {
        ArrayList<String> ans = new ArrayList<String>();
        for (int halfpos=1; halfpos < s.length(); halfpos++) {
            String num1 = s.substring(0, halfpos);
            String num2 = s.substring(halfpos);
            
            if (isValidIPNum(num1) && isValidIPNum(num2)) {
                ans.add(num1 + "." + num2);
            }
        }
        return ans;
    } 
    
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> IPs = new ArrayList<String>();
        if (s.length() >= 4 && s.length() <= 12) {
            // each half should have at least 2 digit
            for (int halfpos=2; halfpos < s.length()-1; halfpos++) {
                ArrayList<String> firsthalf  = halfIP(s.substring(0, halfpos));
                ArrayList<String> secondhalf = halfIP(s.substring(halfpos));
                if (!firsthalf.isEmpty() && !secondhalf.isEmpty()) {
                    for (String first : firsthalf) {
                        for (String second : secondhalf) {
                            IPs.add(first + "." + second);
                        }
                    }
                }
            }
        }
        return IPs;
    }
}
