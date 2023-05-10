package com.example.music_server.service;

import com.example.music_server.domain.Collect;
import com.example.music_server.service.impl.CollectServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CollectServiceTest {
    @Autowired
    private CollectServiceImpl collectService;
    private Collect collect = new Collect();


    @Test
    void deleteCollect() {
        boolean result_Delete = collectService.deleteCollect(31,128);
        assertTrue(result_Delete);
    }

    @Test
    void addCollection() {
        collect.setUserId(31);
        collect.setType(new Byte("0"));
        collect.setSongId(128);
        collect.setCreateTime(new Date());
        boolean result_Add = collectService.addCollection(collect);
        assertTrue(result_Add);
    }

    @Test
    void existSongId() {
        boolean result = collectService.existSongId(31,128);
        if(result){
            deleteCollect();
            assertFalse(collectService.existSongId(31,128));
            addCollection();
            assertTrue(collectService.existSongId(31,128));
        }
        else{
            addCollection();
            assertTrue(collectService.existSongId(31,128));
            deleteCollect();
            assertFalse(collectService.existSongId(31,128));
        }

        //assertTrue(collectService.existSongId(35,124));
    }

    @Test
    void collectionOfUser() {
        List<Collect> test = collectService.collectionOfUser(31);
        System.out.println(test);
    }
}