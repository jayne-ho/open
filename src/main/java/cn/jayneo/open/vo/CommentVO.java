package cn.jayneo.open.vo;

import java.io.Serializable;
import java.util.Date;

public class CommentVO implements Serializable {

    private String firstName;//名
    private String lastName;//姓
    private String content;
    private Integer fid;
    private Integer uid;
    private Date pubDate;

    @Override
    public String toString() {
        return "CommentVO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", content='" + content + '\'' +
                ", fid=" + fid +
                ", uid=" + uid +
                ", pubDate=" + pubDate +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
