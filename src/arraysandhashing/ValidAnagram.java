package arraysandhashing;

import java.util.HashMap;

/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:
        Input: s = "anagram", t = "nagaram"
        Output: true
Example 2:
        Input: s = "rat", t = "car"
        Output: false
Constraints:
        1 <= s.length, t.length <= 5 * 104
        s and t consist of lowercase English letters.*/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            map.merge(c, 1, Integer::sum);
        }

        for(Character c1 : t.toCharArray()){
            map.merge(c1, -1, Integer::sum);
        }

        map.values().removeIf(v-> v==0);
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram(s, t));
    }
}
