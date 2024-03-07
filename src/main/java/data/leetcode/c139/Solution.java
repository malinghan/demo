package data.leetcode.c139;

import java.util.ArrayList;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 设 boolean[] f表示长度为s是否能表示完成
        // f[s] = f[s- wordDict[i]]
        boolean[] f = new boolean [s.length()+1];
        //apple apple
        f[0] = true;
        for(int i = 1;  i <= s.length(); i ++) {
            for(int j = 0; j < wordDict.size(); j++) {
                String temp = wordDict.get(j);
                int len = i - temp.length();
                //i = 5
                if (len >= 0 && s.startsWith(temp, i - temp.length())) {
                    if (f[i - temp.length()]) {
                        f[i] = true;
                        break;
                    }
                }
            }
        }
        return f[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new Solution().wordBreak("leetcode", wordDict));
    }
}
// s = leetcode
// f[0] true
// f[1,2,3] false
// f[4] temp = leet len = 0 s.substing(4-4,4)
