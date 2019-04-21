package cn.jayneo.open.controller;

import cn.jayneo.open.entity.CommentEntity;
import cn.jayneo.open.entity.FilmEntity;
import cn.jayneo.open.service.IFilmService;
import cn.jayneo.open.utils.ResponseResult;
import cn.jayneo.open.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("films")
public class FilmController extends BaseController {

    @Autowired
    private IFilmService filmService;

    @GetMapping("/")
    public ResponseResult<List<FilmEntity>> getFilms(){
        List<FilmEntity> films = filmService.getFilms();
        return new ResponseResult<>(SUCESS,films);
    }

    @GetMapping("{fid}/details")
    public ResponseResult<FilmEntity> getFilmByCid(@PathVariable("fid") Integer fid){
        FilmEntity byCd = filmService.getByCd(fid);
        return new ResponseResult<>(SUCESS,byCd);
    }

    @GetMapping("{fid}/comment")
    public ResponseResult<CommentVO> getComment(@PathVariable("fid") Integer fid){
        CommentVO commentByFid = filmService.getCommentByFid(fid);
        return new ResponseResult<>(SUCESS,commentByFid);
    }

    @RequestMapping("addcomment")
    public ResponseResult<Void> pubComment(CommentEntity comment, HttpSession session){
        Integer uidFromSession = getUidFromSession(session);
        comment.setUid(uidFromSession);
        filmService.pubComment(comment);
        return new ResponseResult<>(SUCESS);
    }

}
