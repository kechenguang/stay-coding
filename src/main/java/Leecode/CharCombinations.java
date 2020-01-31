package Leecode;

import java.util.*;

public class CharCombinations {

    private class CharInfo {

        private String sortString;

        CharInfo(String s1) {

            char[] chars = s1.toCharArray();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                list.add(Integer.valueOf(chars[i]));
            }
            Collections.sort(list);
            this.sortString = new String(list.toString());
        }

        @Override
        public boolean equals(Object o) {

            CharInfo charInfo = (CharInfo) o;
            if (charInfo.sortString.equals(this.sortString)) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {

            return this.sortString.hashCode();
        }

        public List<List<String>> groupAnagrams(String[] strs) {

            HashMap<CharInfo, List<String>> hashMap = new HashMap<>();
            List<List<String>> res = new ArrayList<>();
            for (String s : strs) {
                CharInfo c = new CharInfo(s);
                if (hashMap.get(c) != null) {
                    List<String> list = hashMap.get(c);
                    list.add(s);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(s);
                    hashMap.put(c, list);
                }
            }
            for (Map.Entry<CharInfo, List<String>> entry : hashMap.entrySet()) {
                res.add(entry.getValue());
            }
            return res;
        }
    }
}


