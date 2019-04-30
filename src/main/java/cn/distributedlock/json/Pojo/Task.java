package cn.distributedlock.json.Pojo;

import java.util.List;

/**
 * Created by nizy on 2019/2/21.
 */
public class Task {

    private Long id;

    private String inside_task_id;

    private String accesser_user_code;

    private String outside_task_id;

    private int status;

    private String start_time;

    private String end_time;

    private String project_id;

    private int extend_status;

    private List<Url> url_count_list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInside_task_id() {
        return inside_task_id;
    }

    public void setInside_task_id(String inside_task_id) {
        this.inside_task_id = inside_task_id;
    }

    public String getAccesser_user_code() {
        return accesser_user_code;
    }

    public void setAccesser_user_code(String accesser_user_code) {
        this.accesser_user_code = accesser_user_code;
    }

    public String getOutside_task_id() {
        return outside_task_id;
    }

    public void setOutside_task_id(String outside_task_id) {
        this.outside_task_id = outside_task_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public int getExtend_status() {
        return extend_status;
    }

    public void setExtend_status(int extend_status) {
        this.extend_status = extend_status;
    }

    public List<Url> getUrl_count_list() {
        return url_count_list;
    }

    public void setUrl_count_list(List<Url> url_count_list) {
        this.url_count_list = url_count_list;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task{");
        sb.append("id=").append(id);
        sb.append(", inside_task_id='").append(inside_task_id).append('\'');
        sb.append(", accesser_user_code='").append(accesser_user_code).append('\'');
        sb.append(", outside_task_id='").append(outside_task_id).append('\'');
        sb.append(", status=").append(status);
        sb.append(", start_time='").append(start_time).append('\'');
        sb.append(", end_time='").append(end_time).append('\'');
        sb.append(", project_id='").append(project_id).append('\'');
        sb.append(", extend_status=").append(extend_status);
        sb.append('}');
        return sb.toString();
    }
}
