package cn.distributedlock.json.Pojo;


/**
 * Created by nizy on 2019/2/20.
 */

public class Course {

    String courseId;

    String courseName;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("courseId='").append(courseId).append('\'');
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
