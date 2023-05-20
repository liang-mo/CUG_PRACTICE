package com.example.music_server.service;

import com.example.music_server.domain.Singer;
import com.example.music_server.domain.Song;
import com.example.music_server.domain.SongList;
import com.example.music_server.service.impl.SongListServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SongListServiceTest {
    @Autowired
    private SongListServiceImpl songListService;

    static SongList songList = new SongList();
    static void init(){
        String title = "testsonglist";
        String introduction = "null";
        String style = "中国风";
        String pic = "/img/songListPic/123.jpg";
        songList.setTitle(title);
        songList.setIntroduction(introduction);
        songList.setStyle(style);
        songList.setPic(pic);
    }
    @Test
    void addSongList() {
        init();
        assertTrue(songListService.addSongList(songList));
    }

    @Test
    void updateSongListMsg() {
        addSongList();
        songList.setId(93);
        assertTrue(songListService.updateSongListMsg(songList));
        songList.setId(null);
    }

    @Test
    void updateSongListImg() {
        init();
        addSongList();
        songList.setId(93);
        assertTrue(songListService.updateSongListImg(songList));
        songList.setId(null);
    }

    @Test
    void deleteSongList() {
    }

    @Test
    void allSongList() {
    }

    @Test
    void likeTitle() {
    }

    @Test
    void likeStyle() {
    }
}