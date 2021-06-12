import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiangwentao
 * @date 2021/6/12
 * @detail
 */
public class Solution93 {

    private final List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        travrse(s, new LinkedList<>());
        return res;
    }

    private void travrse(String s, LinkedList<String> track) {
        //base case
        if (track.size() == 4) {
            if ("".equals(s)) {
                res.add(String.join(".", track));
            }
            return;
        }
        //选择列表
        for (int i = 1; i < (s.length() < 4 ? s.length() + 1 : 4); i++) {
            //做选择
            String curStr = s.substring(0, i);
            String leaveStr = s.substring(i);
            if (i != 1 && curStr.startsWith("0")) {
                continue;
            }
            if (Integer.parseInt(curStr) > 255) {
                return;
            }
            track.add(curStr);
            travrse(leaveStr, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        List<String> list = solution93.restoreIpAddresses("0000");
        System.out.println(list);
    }
}
