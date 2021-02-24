package cn;

import lombok.Data;

import java.util.Objects;

@Data
public class SqlResult {
    private String messageId;
    private String collection;
    private String mainId;
    private String relationId;
    private long createTime;
    private long recevieTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SqlResult sqlResult = (SqlResult) o;
        return collection.equals(sqlResult.collection) &&
                mainId.equals(sqlResult.mainId) &&
                relationId.equals(sqlResult.relationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collection, mainId, relationId);
    }

    @Override
    public String toString() {
        return "SqlResult{" +
                "messageId='" + messageId + '\'' +
                ", collection='" + collection + '\'' +
                ", mainId='" + mainId + '\'' +
                ", relationId='" + relationId + '\'' +
                '}';
    }
}
