package cn.jayneo.open.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论实体类
 */
@Component
public class CommentEntity implements Serializable {

    private Integer cid;
    private String content;
    private Integer fid;
    private Integer uid;
    private Date pubDate;

    @Override
    public String toString() {
        return "CommentEntity{" +
                "gid=" + cid +
                ", content='" + content + '\'' +
                ", fid=" + fid +
                ", uid=" + uid +
                ", pubDate=" + pubDate +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer gid) {
        this.cid = gid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}
