import java.util.*;

/**
 * @author jiangwentao
 * @date 2021/6/3
 * @detail 设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，
 * 关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * <p>
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。
 * 每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 * <p>
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 * <p>
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 * <p>
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution355 {

    public static int timeStamp = 0;

    static class Twitter {

        private HashMap<Integer, User> userMap = new HashMap<>();

        class Tweet {
            //推特id
            private int id;
            //推特发文时间
            private int time;
            //下一条推特
            private Tweet next;

            public Tweet(int id, int time) {
                this.id = id;
                this.time = time;
                this.next = null;
            }
        }

        class User {
            //用户id
            private int id;
            //追随者id列表
            public Set<Integer> followers;
            //当前用户的第一条推特
            private Tweet head;

            public User(int id) {
                this.followers = new HashSet<>();
                this.id = id;
                this.head = null;
                //首先关注自己
                follow(id);
            }

            //关注一个人
            public void follow(int userId) {
                this.followers.add(userId);
            }

            //取关一个人
            public void unFollow(int userId) {
                //不可以取关自己
                if (userId == this.id) {
                    return;
                }
                this.followers.remove(userId);
            }

            //发推特
            public void post(int tweetId) {
                Tweet tweet = new Tweet(tweetId, timeStamp);
                timeStamp++;
                //将新建的推文插入链表头
                //越靠前的推文time 越大
                tweet.next = head;
                head = tweet;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public Twitter() {

        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            if (!userMap.containsKey(userId)) {
                userMap.put(userId, new User(userId));
            }
            User user = userMap.get(userId);
            user.post(tweetId);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            if (!userMap.containsKey(userId)) {
                return res;
            }
            Set<Integer> followerIds = userMap.get(userId).followers;
            PriorityQueue<Tweet> queue = new PriorityQueue<>(followerIds.size(), (a, b) -> (b.time - a.time));
            //先将所有普链表头节点插入优先级队列
            for (int id : followerIds) {
                Tweet headTweet = userMap.get(id).head;
                if (headTweet == null) {
                    continue;
                }
                queue.add(headTweet);
            }
            while (!queue.isEmpty()) {
                //返回最多十条
                if (res.size() == 10) {
                    break;
                }
                //弹出time值最大的（最近发表的）
                Tweet tweet = queue.poll();
                res.add(tweet.id);
                //将下一篇Tweet插入进行排序
                if (tweet.next != null) {
                    queue.add(tweet.next);
                }
            }
            return res;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (!userMap.containsKey(followeeId)) {
                userMap.put(followeeId, new User(followeeId));
            }
            if (!userMap.containsKey(followerId)) {
                userMap.put(followerId, new User(followerId));
            }
            //被跟随者
            User followee = userMap.get(followeeId);
            followee.follow(followerId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (!userMap.containsKey(followeeId) || !userMap.containsKey(followerId)) {
                return;
            }
            //被跟随者
            User followee = userMap.get(followeeId);
            followee.unFollow(followerId);
        }
    }

    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        List<Integer> newsFeed = obj.getNewsFeed(1);
        obj.follow(2, 1);
        obj.postTweet(2, 6);
        List<Integer> newsFeed1 = obj.getNewsFeed(1);
        obj.unfollow(2, 1);
        List<Integer> newsFeed2 = obj.getNewsFeed(1);
    }
}
