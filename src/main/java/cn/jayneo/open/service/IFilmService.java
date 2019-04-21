package cn.jayneo.open.service;

import cn.jayneo.open.entity.CommentEntity;
import cn.jayneo.open.entity.FilmEntity;
import cn.jayneo.open.vo.CommentVO;

import java.util.List;

public interface IFilmService {

    /**
     * 获取影片列表
     * @return
     */
    List<FilmEntity> getFilms();

    /**
     * 根据影片id查询影片详细信息
     * @param fid 影片id
     * @return 匹配的影片详细信息
     */
    FilmEntity getByCd(Integer fid);

    /**
     * 根据影片id查询评论信息
     * @param fid
     * @return
     */
    CommentVO getCommentByFid(Integer fid);

    /**
     * 发表评论
     * @param comment
     */
    void pubComment(CommentEntity comment);

}
