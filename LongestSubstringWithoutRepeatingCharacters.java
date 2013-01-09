import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        int max_len   = 0;
        int cur_len   = 0;
        int cur_start = 0;
        for (int i=0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer last_pos = hash.get(c);
            if (last_pos == null)
                last_pos = -1;
            if (last_pos < cur_start) {
                cur_len++;
            } else {
                if (cur_len > max_len)
                    max_len = cur_len;
                cur_start = last_pos + 1;
                cur_len = i - cur_start + 1;
            }
            hash.put(c, i);
        }
        if (cur_len > max_len)
            max_len = cur_len;
        return max_len;
    }
}
