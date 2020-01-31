package newBegin;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FristOnlyChar {

    public static char getFirstOnlyChar(char[] nums) {

        LinkedHashMap<Character, Integer> characterIntegerLinkedHashMap = new LinkedHashMap<>(20, 0.75f, true);
        for (int i = 0; i < nums.length; i++) {
            if (characterIntegerLinkedHashMap.get(nums[i]) == null) {
                characterIntegerLinkedHashMap.put(nums[i], 1);
            } else {
                characterIntegerLinkedHashMap.put(nums[i], characterIntegerLinkedHashMap.get(nums[i])+ 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : characterIntegerLinkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return 'a';
    }

    public static void main(String args[]) {

        char[] a = new char[]{'a','c','a','b','b','b','a','c'};
        getFirstOnlyChar(a);
    }
}
