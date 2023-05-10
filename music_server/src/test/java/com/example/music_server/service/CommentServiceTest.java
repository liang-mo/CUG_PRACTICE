package com.example.music_server.service;

import com.example.music_server.domain.Comment;
import com.example.music_server.service.impl.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CommentServiceTest {
    @Autowired
    private CommentServiceImpl commentService;
    private Comment comment = new Comment();

    void init(){
        Byte type = new Byte("0");
        comment.setUserId(31);
        comment.setContent("测试评论");
        comment.setType(type);
        comment.setSongId(128);
        comment.setCreateTime(new Date());
    }
    @Test
    void addComment() {
        init();
        Boolean result = commentService.addComment(comment);
        assertTrue(result);
    }

    @Test
    void updateCommentMsg() {
        init();
        comment.setId(55);
        Boolean res = commentService.updateCommentMsg(comment);
        assertTrue(res);
        comment.setId(null);
    }

    @Test
    void deleteComment() {
        init();
        Boolean res = commentService.deleteComment(55);
        assertTrue(res);
    }

    @Test
    void commentOfSongId() {
        System.out.println(commentService.commentOfSongId(124));
    }

    @Test
    void commentOfSongListId() {
        System.out.println(commentService.commentOfSongListId(86));
    }
}