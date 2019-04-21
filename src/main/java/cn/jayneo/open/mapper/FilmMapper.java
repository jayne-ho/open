package cn.jayneo.open.mapper;

import cn.jayneo.open.entity.CommentEntity;
import cn.jayneo.open.entity.FilmEntity;
import cn.jayneo.open.vo.CommentVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 影片处理持久层接口
 */
public interface FilmMapper {

    /**
     * 获取影片列表
     * @return 影片列表
     */
    @Select("select fid,pic,film_name filmName,intro,releas_date releasDate,country,director " +
            "from film")
    List<FilmEntity> findFilms();

    /**
     * 根据影片id查询影片详细信息
     * @param fid 影片id
     * @return 匹配的影片详细信息
     */
    @Select("select fid,pic,film_name filmName,intro,releas_date releasDate,country,director " +
            "from film " +
            "where fid=#{fid}")
    FilmEntity findByCd(Integer fid);

    /**
     * 根据影片id查询评论信息
     * @param fid
     * @return
     */
    @Select("select content, firstName, lastName, pub_date pubDate " +
            "from comment inner join t_user on comment.uid=t_user.uid " +
            "where fid=#{fid}")
    CommentVO findCommentByFid(Integer fid);

    /**
     * 插入评论数据
     * @param comment
     * @return
     */
    @Insert("insert into comment (content, pub_date, fid, uid) values(#{content}, #{pubDate}, #{fid}, #{uid})")
    Integer addComment(CommentEntity comment);


}
