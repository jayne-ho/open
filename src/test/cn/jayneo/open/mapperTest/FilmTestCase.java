package cn.jayneo.open.mapperTest;

import cn.jayneo.open.entity.CommentEntity;
import cn.jayneo.open.entity.FilmEntity;
import cn.jayneo.open.mapper.FilmMapper;
import cn.jayneo.open.vo.CommentVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmTestCase {

    @Resource
    private FilmMapper filmMapper;

    @Test
    public void getFilms(){
        List<FilmEntity> films = filmMapper.findFilms();
        for (FilmEntity film : films) {
            System.err.println(film);
        }
    }

    @Test
    public void findById(){
        FilmEntity byId = filmMapper.findByCd(1);
        System.out.println(byId);
    }

    @Test
    public void findCommentByFid(){
        CommentVO byFid = filmMapper.findCommentByFid(3);
        System.err.println(byFid);
    }

    @Test
    public void addComment(){
        CommentEntity comment = new CommentEntity();
        comment.setContent("还不错,就是比我拍的差了点!");
        comment.setFid(6);
        comment.setPubDate(new Date());
        comment.setUid(3);
        Integer integer = filmMapper.addComment(comment);
        System.err.println(integer);
    }

}
