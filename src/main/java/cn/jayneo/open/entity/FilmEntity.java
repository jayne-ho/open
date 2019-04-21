package cn.jayneo.open.entity;


import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 电影实体类
 */
@Component
public class FilmEntity implements Serializable {

    private Integer fid;//影片id
    private String pic;//影片图片
    private String filmName;//影片名称
    private String intro;//影片简介
    private String releasDate;//上映时间
    private String country;//国家
    private String director;//导演
    private String actors;//演员

    @Override
    public String toString() {
        return "FilmEntity{" +
                "fid=" + fid +
                ", pic='" + pic + '\'' +
                ", filmName='" + filmName + '\'' +
                ", intro='" + intro + '\'' +
                ", releasDate='" + releasDate + '\'' +
                ", country='" + country + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                '}';
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getReleasDate() {
        return releasDate;
    }

    public void setReleasDate(String releasDate) {
        this.releasDate = releasDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
