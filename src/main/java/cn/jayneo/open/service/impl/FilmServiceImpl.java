package cn.jayneo.open.service.impl;

import cn.jayneo.open.entity.CommentEntity;
import cn.jayneo.open.entity.FilmEntity;
import cn.jayneo.open.mapper.FilmMapper;
import cn.jayneo.open.service.IFilmService;
import cn.jayneo.open.service.ex.InsertException;
import cn.jayneo.open.vo.CommentVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class FilmServiceImpl implements IFilmService {

    @Resource
    private FilmMapper filmMapper;

    /**
     * 获取影片列表
     * @return
     */
    private List<FilmEntity> findFilms(){
        return filmMapper.findFilms();
    }

    /**
     * 根据影片id查询影片详细信息
     * @param fid 影片id
     * @return 匹配的影片详细信息
     */
    private FilmEntity findByCd(Integer fid){
        return filmMapper.findByCd(fid);
    }

    /**
     * 根据影片id查询评论信息
     * @param fid
     * @return
     */
    private CommentVO findCommentByFid(Integer fid){
        return filmMapper.findCommentByFid(fid);
    }

    /**
     * 发表评论
     * @param comment
     * @return
     */
    private void addComment(CommentEntity comment){
        Integer integer = filmMapper.addComment(comment);
        if (integer != 1){
            throw new InsertException("评论失败!出现未知错误!请稍后重试!");
        }
    }


    @Override
    public List<FilmEntity> getFilms() {
        return findFilms();
    }

    @Override
    public FilmEntity getByCd(Integer fid) {
        return findByCd(fid);
    }

    @Override
    public CommentVO getCommentByFid(Integer fid) {
        return findCommentByFid(fid);
    }

    @Override
    public void pubComment(CommentEntity comment) {
        comment.setPubDate(new Date());
        addComment(comment);
    }
}
