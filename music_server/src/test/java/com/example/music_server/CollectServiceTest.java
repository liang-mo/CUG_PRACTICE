package com.example.music_server;

import com.example.music_server.domain.Collect;
import com.example.music_server.service.impl.CollectServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CollectServiceTest {
    @Autowired
    private CollectServiceImpl collectService;
    private Collect collect = new Collect();


    @Test
    void deleteCollect() {
        boolean result_Delete = collectService.deleteCollect(35,124);
        assertTrue(result_Delete);
    }

    @Test
    void addCollection() {
        collect.setUserId(35);
        collect.setType(new Byte("0"));
        collect.setSongId(124);
        collect.setCreateTime(new Date());
        boolean result_Add = collectService.addCollection(collect);
        assertTrue(result_Add);
    }

    @Test
    void existSongId() {
        boolean result = collectService.existSongId(35,124);
        if(result){
            deleteCollect();
            assertFalse(collectService.existSongId(35,124));
            addCollection();
            assertTrue(collectService.existSongId(35,124));
        }
        else{
            addCollection();
            assertTrue(collectService.existSongId(35,124));
            deleteCollect();
            assertFalse(collectService.existSongId(35,124));
        }

        //assertTrue(collectService.existSongId(35,124));
    }

    @Test
    void collectionOfUser() {
        List<Collect> test = collectService.collectionOfUser(35);
        System.out.println(test);
    }
}