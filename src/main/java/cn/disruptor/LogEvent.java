package cn.disruptor;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @author kelai 2020-03-23 18:11
 */
public class LogEvent {
    private long logId;
    private String content;
    private Date date;

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
