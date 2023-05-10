package com.example.music_server.service;

import com.example.music_server.domain.RankList;
import com.example.music_server.service.impl.RankListServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RankListServiceTest {

    @Autowired
    private RankListServiceImpl rankListService;

    @Test
    void addRank() {
        String songListId = "3";
        String consumerId = "29";
        String score = "4";
        RankList rank_list = new RankList();
        rank_list.setSongListId(new Long(1));
        rank_list.setConsumerId(new Long(29));
        rank_list.setScore(new Integer(8));
        assertTrue(rankListService.addRank(rank_list));
    }

    @Test
    void rankOfSongListId() {
        String songListId = "3";
        assertEquals(4,rankListService.rankOfSongListId(new Long(songListId)));
    }

    @Test
    void getUserRank() {
        assertEquals(3,rankListService.getUserRank(new Long("29"),new Long("3")));
    }
}