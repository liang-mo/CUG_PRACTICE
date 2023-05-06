package com.example.music_server.service;

import com.example.music_server.domain.Collect;

import java.util.List;

public interface CollectService {

    boolean addCollection(Collect collect);

    boolean existSongId(Integer userId, Integer songId);

    boolean deleteCollect(Integer userId, Integer songId);

    List<Collect> collectionOfUser(Integer userId);
}
