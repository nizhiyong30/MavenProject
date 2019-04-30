package cn.distributedlock.json.Pojo;

/**
 * Created by nizy on 2019/2/21.
 */
public class Url {

    private String type;

    private String url;

    private int count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Url{");
        sb.append("type='").append(type).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }
}
