package cn.jayneo.open.service;

import cn.jayneo.open.entity.CommentEntity;
import cn.jayneo.open.entity.FilmEntity;
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
public class FilmTeseCase {

    @Resource
    private IFilmService filmService;

    @Test
    public void getFilms(){
        List<FilmEntity> films = filmService.getFilms();
        for (FilmEntity film : films) {
            System.err.println(film);
        }
    }

    @Test
    public void getByCd(){
        FilmEntity byCd = filmService.getByCd(3);
        System.err.println(byCd);
    }

    @Test
    public void getCommentByFid(){
        CommentVO commentByFid = filmService.getCommentByFid(3);
        System.err.println(commentByFid);
    }

    @Test
    public void pubComment(){
        CommentEntity comment = new CommentEntity();
        comment.setContent("不好看!差评!");
        comment.setFid(3);
        comment.setPubDate(new Date());
        comment.setUid(8);
        filmService.pubComment(comment);
    }

}
