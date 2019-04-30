package cn.distributedlock.json.Pojo;


import java.util.List;

/**
 * Created by nizy on 2019/2/20.
 */
public class Teacher {

    String teacherId;

    String teacherName;

    List<Course> courses;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teacher{");
        sb.append("teacherId='").append(teacherId).append('\'');
        sb.append(", teacherName='").append(teacherName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
