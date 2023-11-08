package arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

    Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    Example 2:
    Input: strs = [""]
    Output: [[""]]

    Example 3:
    Input: strs = ["a"]
    Output: [["a"]]

    Constraints:
    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {
    public String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
    //sorting logic
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if(strs.length == 1){
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            result.add(list);
            return result;
        }

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] tempArray = str.toCharArray();
            Arrays.sort(tempArray);
            String key = String.valueOf(tempArray);

            List<String> list;

            if(map.containsKey(key)){
                list = map.get(key);
            }else{
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(key, list);
        }

        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> res = ga.groupAnagrams(ga.strs);

        res.stream().forEach(System.out::println);
    }
}
