package com.example.music_server.service;

import com.example.music_server.service.impl.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {
    @Autowired
    private CommentServiceImpl commentService;
    @Test
    void addComment() {
    }

    @Test
    void updateCommentMsg() {
    }

    @Test
    void deleteComment() {
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