package Arithmatic;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dengmingliang
 * @Description 无重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
 * @ClassName NoRepeatSubString
 * @Date 2019/11/27 9:06 下午
 */
public class NoRepeatSubString {


    /**
     * 遍历穷举
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        s = s.trim();
        if(StringUtils.isBlank(s)){
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }
        String longestSubString = "";
        int longestStringLength = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = s.length(); j > i; j--) {
                String subString = s.substring(i, j);
//                System.out.println(subString);
                Set<Character> subStringchar = new HashSet<>();
                boolean isSubString = true;
                for (int subIndex = 0; subIndex < subString.length(); subIndex++) {
                    if (!subStringchar.contains(subString.charAt(subIndex))) {
                        subStringchar.add(subString.charAt(subIndex));
                    } else {
                        isSubString = false;
                        break;
                    }
                }
                if (isSubString && longestStringLength < subString.length()) {
                    longestSubString = subString;
                    longestStringLength = subString.length();
                }

            }
        }
        System.out.println(longestSubString);
        return longestStringLength;
    }

    /**
     * 滑动窗口 记录字符和字符的位置
     * @param x
     * @return
     */
    public int lengthOfLongestSubstring2(String x){
        HashMap<Character,Integer> charLocation = new HashMap<>();
        int longestLength = 0 ;
        for(int start=0,end = 0;end<x.length();end++){
            char temp = x.charAt(end);

            if(charLocation.containsKey(temp)){
                //说明已经有了
                start = Math.max(charLocation.get(temp)+1,start);

            }
            longestLength = Math.max(end-start+1,longestLength);
            charLocation.put(temp,end);
        }
        return longestLength;
    }


    @Test
    public void test() {
        String[] x = new String[]{"t", "tt", "ta", "sajsnajbfhsbah", "abcdedsdfeqas","abcdedsdfeqasqwertyui","hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"};
//        testCircleNumber(x);

        for (String t : x) {
            System.out.println(t);
            System.out.println(lengthOfLongestSubstring(t));
            System.out.println(lengthOfLongestSubstring2(t));
        }

    }
}
