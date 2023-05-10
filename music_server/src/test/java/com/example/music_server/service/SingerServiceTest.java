package com.example.music_server.service;

import com.example.music_server.domain.Singer;
import com.example.music_server.service.impl.SingerServiceImpl;
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
class SingerServiceTest {

    @Autowired
    private SingerServiceImpl singerService;

    static Singer singer = new Singer();
    static void init(){
        String name = "name";
        String sex = "0";
        String birth = "1956-09-12 22:02:38";
        String location = "中国";
        String introduction = "null";
        String pic = "/img/avatorImages/user.jpg";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        singer.setName(name);
        singer.setSex(new Byte(sex));
        singer.setBirth(myBirth);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        singer.setPic(pic);
    }
    @Test
    void addSinger() {
        init();
        assertTrue(singerService.addSinger(singer));
    }

    @Test
    void updateSingerMsg() {
       addSinger();
       singer.setId(43);
       assertTrue(singerService.updateSingerMsg(singer));
       singer.setId(null);
    }

    @Test
    void updateSingerPic() {
       addSinger();
       singer.setId(43);
       assertTrue(singerService.updateSingerMsg(singer));
       singer.setId(null);
    }

    @Test
    void deleteSinger() {
        addSinger();
        assertTrue(singerService.deleteSinger(43));
    }

    @Test
    void allSinger() {
    }

    @Test
    void singerOfName() {
    }

    @Test
    void singerOfSex() {
    }
}