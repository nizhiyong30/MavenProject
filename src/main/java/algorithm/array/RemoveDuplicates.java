package algorithm.array;

/**
 * [0,0,1,1,1,2,2,3,3,4]
 * @author nizy
 * @date 2022/2/17 4:57 下午
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length) {
            if(nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        String s = "SELECT post.id,post.root,IF (post.id=post.root,1,0) as isTopic,post.userId,post.subject,post.signatured,post.postRewardMoney,UNIX_TIMESTAMP(post.postTime)*1000 AS createtime,post.rating,post.value,post.floor,post.click,post.boardId,IF (post.boardId IN (46,47,48,49,50,51,58,87,88,89,92,93,100,102,103,106,110,112,113,119,131,137,143,146,147,148,171,188,197,231) OR post.postTime>=\"2020-01-01 00:00:00\",1,0) AS isSafe,post.votes,topic.archived,topic.approved,topic.reply,body.body,IF (post.signatured+post.votes+topic.reply> 0,1,0) AS isQualityPost,USER.status AS userStatus,user_case.id AS isBlt, post.username, board.title as boardTitle FROM jute_post post LEFT JOIN jute_post_body body ON post.id=body.id LEFT JOIN jute_topic topic ON post.id=topic.id LEFT JOIN jute_board board ON board.id=post.boardId LEFT JOIN jute_user USER ON USER.id=post.userId LEFT JOIN jute_post post2 ON post.root=post2.id LEFT JOIN jute_user_case user_case ON post.id=user_case.id WHERE post.deleted=0 AND post2.deleted=0 AND post.SUBJECT NOT LIKE \"%签到%\" AND post.id BETWEEN $START AND $END AND char_length(post.SUBJECT)>=2 AND char_length(body.body)>=15 AND post.boardId NOT IN (17,21,52,94,120,124,129,138,142,145,187,200,202,206,218,219,220,256,259,268,273,276,279) AND (post.id=post.root OR (post.posttime>=\"2019-01-01 00:00:00\" AND post.topicid>=100 AND post.votes>=2))";
        s = s.replaceAll("BETWEEN \\$START AND \\$END", "test").replaceAll("BETWEEN \\$start AND \\$end", "test");
    }
}
