package com.example.music_server.service;

import com.example.music_server.domain.ListSong;
import com.example.music_server.service.impl.ListSongServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ListSongServiceTest {
    @Autowired
    private ListSongServiceImpl listSongService;
    static ListSong listSong = new ListSong();
    @Test
    void addListSong() {
        String song_id = "6";
        String song_list_id = "3";
        listSong.setSongId(Integer.parseInt(song_id));
        listSong.setSongListId(Integer.parseInt(song_list_id));
        assertTrue(listSongService.addListSong(listSong));
    }

    @Test
    void updateListSongMsg() {
        addListSong();
        listSong.setId(40);
        assertTrue(listSongService.updateListSongMsg(listSong));
        listSong.setId(null);
    }

    @Test
    void deleteListSong() {
        addListSong();
        assertTrue(listSongService.deleteListSong(listSong.getSongId()));
    }

    @Test
    void allListSong() {
    }

    @Test
    void listSongOfSongId() {
    }
}