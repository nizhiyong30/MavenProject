package cn.DistributedLock.RedisDistributedLock.Json.Pojo;

import java.util.List;

/**
 * Created by nizy on 2019/2/20.
 */
public class Student {

    String studentId;

    String studentName;

    List<Teacher> teachers;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
