package cn.jayneo.open.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 电影类型实体类
 */
@Component
public class GenreEntity implements Serializable {

    private Integer gid;
    private String gname;
    private Integer fid;

    @Override
    public String toString() {
        return "GenreEntity{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", fid=" + fid +
                '}';
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }
}
