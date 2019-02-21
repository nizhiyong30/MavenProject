package cn.DistributedLock.RedisDistributedLock.Json;

import cn.DistributedLock.RedisDistributedLock.Json.Pojo.*;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.List;
import java.util.Map;

/**
 * Created by nizy on 2019/2/20.
 */
public class JsonTest {
    public static void main(String[] args) {
        String json = "{\n" +
                "\t\"students\": [{\n" +
                "\t\t\"studentId\": \"stuId\",\n" +
                "\t\t\"studentName\": \"stuName\",\n" +
                "\t\t\"teachers\": [{\n" +
                "\t\t\t\"teacherId\": \"teacherId\",\n" +
                "\t\t\t\"teacherName\": \"teacherName\",\n" +
                "\t\t\t\"courses\": [{\n" +
                "\t\t\t\t\"courseId\": \"courseId\",\n" +
                "\t\t\t\t\"courseName\": \"courseName\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"courseId\": \"courseId\",\n" +
                "\t\t\t\t\"courseName\": \"courseName\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"courseId\": \"courseId\",\n" +
                "\t\t\t\t\"courseName\": \"courseName\"\n" +
                "\t\t\t}]\n" +
                "\t\t}]\n" +
                "\t}]\n" +
                "}";

        Map<String, List<Student>> map = JSONObject.parseObject(json, Map.class);


        List<Student> students = map.get("students");

        for (Object stuObj : students) {
            Student student = JSONObject.parseObject(JSONObject.toJSONString(stuObj), Student.class);
            for (Object teaObj : student.getTeachers()) {
                Teacher teacher = JSONObject.parseObject(JSONObject.toJSONString(teaObj), Teacher.class);
                for (Object couObj : teacher.getCourses()) {
                    Course course = JSONObject.parseObject(JSONObject.toJSONString(couObj), Course.class);
                    System.out.println(course.getCourseId());
                    System.out.println(course.getCourseName());
                }
            }

        }

    }

    @Test
    public void jsonTest() {
        String json = "{\n" +
                "\t\"errno\": 0,\n" +
                "\t\"data\": [{\n" +
                "\t\t\"id\": 178,\n" +
                "\t\t\"inside_task_id\": \"DMP-20190219-test01\",\n" +
                "\t\t\"accesser_user_code\": \"geqi\",\n" +
                "\t\t\"outside_task_id\": \"au190117_57a0\",\n" +
                "\t\t\"status\": 6,\n" +
                "\t\t\"start_time\": \"2019-01-17T08:23:10.000Z\",\n" +
                "\t\t\"end_time\": \"2019-07-16T08:22:10.000Z\",\n" +
                "\t\t\"project_id\": \"project-01\",\n" +
                "\t\t\"extend_status\": 0,\n" +
                "\t\t\"url_count_list\": [{\n" +
                "\t\t\t\"type\": \"imei_md5\",\n" +
                "\t\t\t\"url\": \"s3://td-dev/ym/geqi/20190117/549a2ae5297a5d6b893134fdadb0a5a0.txt\",\n" +
                "\t\t\t\"count\": 9\n" +
                "\t\t}]\n" +
                "\t}, {\n" +
                "\t\t\"id\": 179,\n" +
                "\t\t\"inside_task_id\": \"DMP-20190117162324-a7f7aa7fcef5e293d5888da267bb4234-geqi\",\n" +
                "\t\t\"accesser_user_code\": \"geqi\",\n" +
                "\t\t\"outside_task_id\": \"au190117_1242\",\n" +
                "\t\t\"status\": 6,\n" +
                "\t\t\"start_time\": \"2019-01-17T08:24:24.000Z\",\n" +
                "\t\t\"end_time\": \"2019-07-16T08:23:24.000Z\",\n" +
                "\t\t\"project_id\": null,\n" +
                "\t\t\"extend_status\": 1,\n" +
                "\t\t\"url_count_list\": [{\n" +
                "\t\t\t\"type\": \"imei_md5\",\n" +
                "\t\t\t\"url\": \"s3://td-dev/ym/geqi/20181224/549a2ae5297a5d6b893134fdadb0a5a0.txt\",\n" +
                "\t\t\t\"count\": 9\n" +
                "\t\t}, {\n" +
                "\t\t\t\"type\": \"imei_md5\",\n" +
                "\t\t\t\"url\": \"hdfs://getui-bi-dev/data/dept/getui_ad/gedeng/idmapping_looklike_idmapping/20190219/query_idmapping_user_output_gid/DMP-20190117162324-a7f7aa7fcef5e293d5888da267bb4234-geqi/*\"\n" +
                "\t\t}]\n" +
                "\t}],\n" +
                "\t\"cost\": \"12.00\"\n" +
                "}";

        Map<String, Object> map = JSONObject.parseObject(json, Map.class);

        System.out.println(map.get("errno"));

        List<Object> tasks = (List<Object>)map.get("data");

        for(Object taskObj : tasks) {
            Task task = JSONObject.parseObject(JSONObject.toJSONString(taskObj), Task.class);
            System.out.println(task.toString());

            for(Object courseObj : task.getUrl_count_list()) {
                Url url = JSONObject.parseObject(JSONObject.toJSONString(courseObj), Url.class);
                System.out.println(url.toString());
            }
        }


    }
}
