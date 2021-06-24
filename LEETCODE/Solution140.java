import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiangwentao
 * @date 2021/6/23
 * @detail 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution140 {

    private List<String> res = new ArrayList<>();

//    public List<String> wordBreak(String s, List<String> wordDict) {
//
//        char[] chars = s.toCharArray();
//        backtrack(s, new LinkedList<>(), wordDict, 0);
//        return res;
//    }
//
//    private void backtrack(String s, LinkedList<String> track, List<String> wordDict, int start) {
//        //base case
//        if (start >= s.length() - 1) {
//            LinkedList<String> temp = new LinkedList<>(track);
//            res.add(String.join(" ", temp));
//            return;
//        }
//        //选择列表
//        for (int i = start; i <= s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                String substring = s.substring(i, j);
//                if (!wordDict.contains(substring)) {
//                    continue;
//                }
//                track.add(substring);
//                start = i + substring.length();
//                backtrack(s, track, wordDict, start);
//                track.removeLast();
//                start = start - substring.length();
//            }
//        }
//    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        String[] wordDirctArr = new String[wordDict.size()];
        for (int i = 0; i < wordDict.size(); i++) {
            wordDirctArr[i] = wordDict.get(i);
        }
        backtrack(wordDirctArr, new LinkedList<>(), s);
        return res;
    }

    private void backtrack(String[] wordDirctArr, LinkedList<String> track, String s) {

        //base case
        if (listStrLen(track) > s.length()) {
            return;
        }
        String str = String.join("", track);
        if (s.equals(str)) {
            res.add(String.join(" ", track));
            return;
        }
        //选择列表
        for (String value : wordDirctArr) {
            track.add(value);
            backtrack(wordDirctArr, track, s);
            track.removeLast();
        }
    }

    private int listStrLen(LinkedList<String> track) {
        int len = 0;
        for (String s : track) {
            len += s.length();
        }
        return len;
    }

    public static void main(String[] args) {
        Solution140 solution140 = new Solution140();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        List<String> list = solution140.wordBreak("pineapplepenapple", wordDict);
        System.out.println(list);
    }
}
