package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class DynamicWindow {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int maxSubstring = 0;
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            max = Math.max(max, map.get(s.charAt(right)));

            while (right - left + 1 - max > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            maxSubstring = Math.max(maxSubstring, right - left + 1);
        }

        return maxSubstring;
    }
}
